package com.hopline.WebApp.translator;

import com.hopline.WebApp.model.dao.User;
import com.hopline.WebApp.model.vo.UserVo;

public class UserTranslator {
	
	public static UserVo toVO(User user) {
		UserVo userVO = new UserVo();
		userVO.setPhone(user.getPhone());
		userVO.setName(user.getName());
		userVO.setIduser(user.getIduser());
		return userVO;
	}

	
	public static User toDao(UserVo userVO) {
		User user = new User();
		if (userVO.getIduser() != null)
			user.setIduser(userVO.getIduser());
		
		user.setPhone(userVO.getPhone());
		user.setName(userVO.getName());
		return user;
	}
}

