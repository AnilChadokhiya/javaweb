package com.techforce.ultil;

import com.techforce.dao.UserDao;
import com.techforce.dao.impl.UserDaoImpl;

public class ApplicationUtils {

	private static UserDao userDao;

	public static UserDao getUserDao() {

	if ( userDao == null ) {
		userDao = new UserDaoImpl();
	}
	return userDao;
	}

}
