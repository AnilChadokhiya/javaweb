package com.techforce.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.techforce.connection.DbConnection;
import com.techforce.dao.UserDao;
import com.techforce.pojo.UserPojo;

public class UserDaoImpl implements UserDao {

	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;

	private final String USER_INSERT_QUERY = "insert into db_tech.tbl_user (user_id ,mobileno, salary , password, first_name,last_name,city , email_id , user_name)"
			+ "VALUES(?,?,?,?,?,?,?,?,?)";

	private final String USER_UPDATE_QUERY = "UPDATE db_tech.tbl_user SET mobileno = ? , salary = ? , "
			+ "password = ? , first_name = ? , last_name = ? , city = ? , email_id = ?  , user_name = ? WHERE user_id = ?";

	private final String QUERY_GET_USER_BY_ID = "SELECT * FROM db_tech.tbl_user where user_id = ? ";

	private final String QUERY_LOGIN = "SELECT * FROM db_tech.tbl_user where user_name = ? and password = ? ";

	private final String QUERY_GET_ALL_USER = "SELECT * FROM db_tech.tbl_user";

	private final String QUERY_GET_LAST_USER_ADD = "SELECT MAX(user_id) as user_id FROM tbl_user; ";

	private final String QUERY_DELETE_USER_BY_ID = "delete FROM db_tech.tbl_user where user_id = ?";

	private final String USER_ID = "user_id", FIRST_NAME = "first_name", LAST_NAME = "last_name", PASSWORD = "password",
			MOBILE_NO = "mobileno", CITY = "city", SALARY = "salary", EMAIL_ID = "email_id", USER_NAME = "user_name";

	@Override
	public int insertUser( UserPojo pojo ) {

		try {

			con = DbConnection.getConnection();

			final int id = getLastAddUserId();

			ps = con.prepareStatement( USER_INSERT_QUERY );

			if ( id > 0 ) {
				ps.setInt( 1, id + 1 );
			} else {
				ps.setInt( 1, 1 );
			}
			ps.setString( 2, pojo.getMobileNo() );
			ps.setFloat( 3, pojo.getSalary() );
			ps.setString( 4, pojo.getPassword() );
			ps.setString( 5, pojo.getFirstName() );
			ps.setString( 6, pojo.getLastName() );
			ps.setString( 7, pojo.getCity() );
			ps.setString( 8, pojo.getEmailId() );
			ps.setString( 9, pojo.getUserName() );

			return ps.executeUpdate();

		} catch ( final SQLException e ) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
			} catch ( final SQLException e ) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	@Override
	public int updateUser( UserPojo pojo ) {

		try {
			con = DbConnection.getConnection();

			ps = con.prepareStatement( USER_UPDATE_QUERY );
			ps.setString( 1, pojo.getMobileNo() );
			ps.setFloat( 2, pojo.getSalary() );
			ps.setString( 3, pojo.getPassword() );
			ps.setString( 4, pojo.getFirstName() );
			ps.setString( 5, pojo.getLastName() );
			ps.setString( 6, pojo.getCity() );
			ps.setString( 7, pojo.getEmailId() );
			ps.setString( 8, pojo.getUserName() );
			ps.setInt( 9, pojo.getId() );

			return ps.executeUpdate();

		} catch ( final SQLException e ) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				rs.close();
			} catch ( final SQLException e ) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	@Override
	public int deleteUseById( int userId ) {
		try {
			con = DbConnection.getConnection();
			ps = con.prepareStatement( QUERY_DELETE_USER_BY_ID );
			ps.setInt( 1, userId );

			return ps.executeUpdate();

		} catch ( final SQLException e ) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				rs.close();
			} catch ( final SQLException e ) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	@Override
	public UserPojo getUserPojoById( int userId ) {

		final UserPojo user = new UserPojo();
		try {
			con = DbConnection.getConnection();

			ps = con.prepareStatement( QUERY_GET_USER_BY_ID );
			ps.setInt( 1, userId );

			rs = ps.executeQuery();
			while ( rs.next() ) {

				user.setId( rs.getInt( USER_ID ) );
				user.setPassword( rs.getString( PASSWORD ) );
				user.setFirstName( rs.getString( FIRST_NAME ) );
				user.setLastName( rs.getString( LAST_NAME ) );
				user.setCity( rs.getString( CITY ) );
				user.setMobileNo( rs.getString( MOBILE_NO ) );
				user.setEmailId( rs.getString( EMAIL_ID ) );
				user.setSalary( rs.getFloat( SALARY ) );
				user.setUserName( rs.getString( USER_NAME ) );
			}

		} catch ( final SQLException e ) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
			} catch ( final SQLException e ) {
				e.printStackTrace();
			}
		}

		return user;
	}

	@Override
	public List< UserPojo > getAllUser() {

		final List< UserPojo > userList = new ArrayList< UserPojo >();
		try {
			con = DbConnection.getConnection();
			ps = con.prepareStatement( QUERY_GET_ALL_USER );

			rs = ps.executeQuery();
			while ( rs.next() ) {

				final UserPojo user = new UserPojo();
				user.setId( rs.getInt( USER_ID ) );
				user.setPassword( rs.getString( PASSWORD ) );
				user.setFirstName( rs.getString( FIRST_NAME ) );
				user.setLastName( rs.getString( LAST_NAME ) );
				user.setCity( rs.getString( CITY ) );
				user.setMobileNo( rs.getString( MOBILE_NO ) );
				user.setEmailId( rs.getString( EMAIL_ID ) );
				user.setSalary( rs.getFloat( SALARY ) );
				user.setUserName( rs.getString( USER_NAME ) );

				userList.add( user );
			}

		} catch ( final SQLException e ) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
			} catch ( final SQLException e ) {
				e.printStackTrace();
			}
		}
		return userList;
	}

	@Override
	public UserPojo userLogin( String userName, String password ) {

		final UserPojo user = new UserPojo();
		try {
			con = DbConnection.getConnection();

			ps = con.prepareStatement( QUERY_LOGIN );
			ps.setString( 1, userName );
			ps.setString( 2, password );

			rs = ps.executeQuery();
			while ( rs.next() ) {

				user.setId( rs.getInt( USER_ID ) );
				user.setPassword( rs.getString( PASSWORD ) );
				user.setFirstName( rs.getString( FIRST_NAME ) );
				user.setLastName( rs.getString( LAST_NAME ) );
				user.setCity( rs.getString( CITY ) );
				user.setMobileNo( rs.getString( MOBILE_NO ) );
				user.setEmailId( rs.getString( EMAIL_ID ) );
				user.setSalary( rs.getFloat( SALARY ) );
				user.setUserName( rs.getString( USER_NAME ) );
			}

		} catch ( final SQLException e ) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
			} catch ( final SQLException e ) {
				e.printStackTrace();
			}
		}
		return user;
	}

	private int getLastAddUserId() {

		try {
			con = DbConnection.getConnection();
			ps = con.prepareStatement( QUERY_GET_LAST_USER_ADD );

			rs = ps.executeQuery();
			System.out.println( "rssss ==>>> " + rs );
			while ( rs.next() ) {
				System.out.println( " id ===>>> " + rs.getInt( USER_ID ) );
				return rs.getInt( USER_ID );
			}

		} catch ( final SQLException e ) {
			e.printStackTrace();
		}

		return 0;
	}

}
