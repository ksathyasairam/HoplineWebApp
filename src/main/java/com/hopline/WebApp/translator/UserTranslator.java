package com.hopline.WebApp.translator;

import com.hopline.WebApp.model.dao.User;
import com.hopline.WebApp.model.vo.UserVo;

public class UserTranslator {
	
	public static UserVo toVO(User user) {
		UserVo userVO = new UserVo();
		userVO.setPhone(user.getPhone());
		userVO.setUserName(user.getName());
		userVO.setUserId(user.getIduser());
		return userVO;
	}

	
	public static User toDao(UserVo userVO) {
		User user = new User();
		if (userVO.getUserId() != null)
			user.setIduser(userVO.getUserId());
		
		user.setPhone(userVO.getPhone());
		user.setName(userVO.getUserName());
		return user;
	}
}

