package com.alacriti.inventory.db;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.log4j.Logger;

public class DBUtil {
	
	
	public static final Logger log= Logger.getLogger(DBUtil.class);
	
	public static void closeConnection(Connection conn,boolean isError)
	{
		if(isError)
		{
			rollbackChanges(conn);
			log.info("Changes rolled Back");
		}
		else
		{
			commitChanges(conn);
			log.info("Changes Committed");
		}
		closeConnection(conn);	
		
	}
	
	
	public static void closeConnection(Connection connection)
	{
		if (connection != null) {
			try 
			{
				connection.close();
				log.info("Connection Closed.");
			} 
			catch (SQLException e)
			{
				log.error("Exception Occured while closing Connection :"+e);
			}
		}
		
	}
	
	public static Connection getConnection()
	{
		DataSource dataSource = null;
		Connection connection = null;
		try
		{
			
			dataSource = (DataSource) new InitialContext()
					.lookup("java:jboss/datasources/TRAINEEE");
			
			connection = dataSource.getConnection();
			connection.setAutoCommit(false);
			log.info("Connection Created...");
			
		}
		catch(Exception e)
		{
			
			log.error("Exception Occured while creating Connection :"+e);
			
		}
		
		return connection;
	}
	
	
	
	public static  void rollbackChanges(Connection connection)
	{
		try
		{
			connection.rollback();
			
		} 
		catch (SQLException e)
		{
			
			log.error("Exception Occured while rollingBack changes :"+e);
		}
	}
	
	
	
	
	public static  void commitChanges(Connection connection)
	{
		try 
		{
			connection.commit();
			
		} 
		catch (SQLException e) 
		{
			log.error("Exception Occured while Committing Changes :"+e);
		}
	}


}
