package com.hopline.WebApp.service;

import java.util.Date;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.RandomUtils;

import com.hopline.WebApp.dao.SecurityDao;
import com.hopline.WebApp.model.dao.SecurityToken;
import com.hopline.WebApp.model.dao.User;
import com.hopline.WebApp.model.vo.UserVo;
import com.hopline.WebApp.rest.framework.ConversionUtil;
import com.hopline.WebApp.rest.framework.EncryptionUtil;
import com.hopline.WebApp.rest.framework.IService;
import com.hopline.WebApp.rest.framework.Util;
import com.hopline.WebApp.translator.UserTranslator;

public class SecurityService extends IService{

	private SecurityDao securityDao;
	
	public SecurityToken createSecurityToken(int userId) throws Exception {
		securityDao.delete(userId);
		
		String tokenString = generateToken(userId);
		
		SecurityToken securityToken = new SecurityToken();
		securityToken.setSecurityToken(tokenString);
		User user = new User();
		user.setIduser(userId);
		securityToken.setUser(user);
		securityToken.setCreateTs(Util.getCurrentDateTimeIndia());
		Integer id = securityDao.saveToken(securityToken);
		securityToken.setIdSecurityToken(id);
		
		return securityToken;
	}
	
	public UserVo retrieveUserFromToken(String securityTokenString) {
		SecurityToken securityToken = securityDao.getTokenbyTokenString(securityTokenString);
		if (securityToken == null) return null;
		
		return UserTranslator.toVO(securityToken.getUser());
	}

	
	private String generateToken(int userId) throws Exception {
		StringBuilder str = new StringBuilder();
		str.append(userId).append("|");
		long salt = RandomUtils.nextLong(1000000, 99999999);
		str.append(salt).append("|");
		Date now = Util.getCurrentDateTimeIndia();
		str.append(now.getTime()).append("|");

		String token = ConversionUtil.truncateString(
				Base64.encodeBase64URLSafeString(EncryptionUtil.encrypt(str.toString(), false).getBytes("UTF-8")), 256);

		return token;
	}


	public SecurityDao getSecurityDao() {
		return securityDao;
	}


	public void setSecurityDao(SecurityDao securityDao) {
		this.securityDao = securityDao;
	}
	
	
}
