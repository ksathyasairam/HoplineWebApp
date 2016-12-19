package com.hopline.WebApp.service;

import com.hopline.WebApp.dao.UserDao;
import com.hopline.WebApp.model.dao.User;
import com.hopline.WebApp.model.vo.UserVo;
import com.hopline.WebApp.rest.framework.IService;
import com.hopline.WebApp.translator.UserTranslator;

public class LoginServiceImpl extends IService{
	private UserDao userDao;
	
	public UserVo login(UserVo userVo) {
		User user = userDao.getUserByPhone(userVo.getPhone());
		
		if (user == null) {
			user = UserTranslator.toDao(userVo);
			Integer id = userDao.saveUser(user);
			user.setIduser(id);
		} else if (user.getMac() == null && userVo.getMac() != null) {
			user.setMac(userVo.getMac());
			userDao.udpateUser(user);
			user = userDao.getUserByPhone(userVo.getPhone());
		}
			
		return UserTranslator.toVO(user);
	}
	
	public UserVo retrieveUserByMacId(String macId) {
		User user = userDao.getUserByMacId(macId);
		
		if (user != null) {
			return UserTranslator.toVO(user);
		}
		
		return null;
			
	}
	
	
	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
