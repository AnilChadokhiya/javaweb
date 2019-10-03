package com.techforce.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

	private static Connection con;

	public static Connection getConnection() {

	if ( con == null ) {

		try {

			Class.forName( "com.mysql.cj.jdbc.Driver" );
			con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/db_tech?useSSL=false", "root", "root" );

			System.out.println( "DataBase Connection ==>> " + con.isClosed() );
		} catch ( final ClassNotFoundException e ) {
			e.printStackTrace();
		} catch ( final SQLException e ) {
			e.printStackTrace();
		}
	}
	return con;
	}

}
