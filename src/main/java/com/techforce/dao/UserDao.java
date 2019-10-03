package com.techforce.dao;

import java.util.List;

import com.techforce.pojo.UserPojo;

public interface UserDao {

	public int insertUser( UserPojo pojo );

	public int updateUser( UserPojo pojo );

	public int deleteUseById( int userId );

	public UserPojo getUserPojoById( int userId );

	public UserPojo userLogin( String userName, String password );

	public List < UserPojo > getAllUser();

}
