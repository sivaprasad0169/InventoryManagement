package com.alacriti.inventory.db;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBUtil {
	
	public static void closeConnection(Connection conn,boolean isError)
	{
		if(isError)
		{
			rollback(conn);
		}
		else
			commit(conn);
		close(conn);	
		
	}
	
	
	public static void close(Connection connection)
	{
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public static Connection getConnection()
	{
		DataSource dataSource = null;
		Connection connection = null;
		try {
			
			dataSource = (DataSource) new InitialContext()
					.lookup("java:jboss/datasources/TRAINEEE");
			
			connection = dataSource.getConnection();
			connection.setAutoCommit(false);
			
		}catch(Exception e){
			System.out.println("Excetion Details  :"+e.getMessage());
		}
		return connection;
	}
	
	
	
	public static  void rollback(Connection connection)
	{
		try {
			connection.rollback();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	
	
	
	public static  void commit(Connection connection)
	{
		try {
			connection.commit();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}


}
