package com.alacriti.inventory.delegate;	

import java.sql.Connection;
import java.util.List;

import org.apache.log4j.Logger;

import com.alacriti.inventory.bo.RegistrationDetailsBO;
import com.alacriti.inventory.db.DBUtil;
import com.alacriti.inventory.models.RegistrationDetailsModel;



public class RegistrationDetailsDelegate {
		
	
		public static final Logger log= Logger.getLogger(RegistrationDetailsDelegate.class);
	
		RegistrationDetailsBO userBO=null;
		
		public List<RegistrationDetailsModel> getAllRegistrationDetails()
		{
			boolean isError=false;
			Connection connection=DBUtil.getConnection();
			List<RegistrationDetailsModel> list=null;
			
			try
			{	
				userBO=new RegistrationDetailsBO();
				list=userBO.getAllRegistrationDetails(connection);			
				
			} 
			catch (Exception e) 
			{
				
				isError=true;
				log.error("Exception Details : getAllRegistrationDetails"+e);
				
			}
			finally 
			{
				
				DBUtil.closeConnection(connection,isError);
			}
			return list;
			
		}
		
		

		public int addRegistrationDetails(RegistrationDetailsModel p[])
		{
			boolean isError=false;
			int noOfRecordsUpdated=0;
			Connection connection=DBUtil.getConnection();
			
			try 
			{
				userBO=new RegistrationDetailsBO();
				noOfRecordsUpdated +=userBO.addRegistrationDetails(connection, p);
				
				
				
			} 
			catch (Exception e)
			{
				
				log.error("Exception Details : addRegistrationDetails "+e);
				isError=true;
				
				
			} 
			finally 
			{
				
				DBUtil.closeConnection(connection,isError);
			}
			return noOfRecordsUpdated;
				
		}
		
		
		

		public int updateDataToTableLoginDetails(RegistrationDetailsModel[] p)
		{			
			
				boolean isError=false;
				int noOfRecordsUpdated=0;
				
				Connection connection=DBUtil.getConnection();
				
				try 
				{	
					userBO=new RegistrationDetailsBO();
					noOfRecordsUpdated +=userBO.updateRegistrationDetails(connection, p);
					
				} 
				catch (Exception e)
				{
					
					log.error("Exception Details : updateDataToTableLoginDetails "+e);
					isError=true;
					
				} 
				finally
				{
					
					DBUtil.closeConnection(connection,isError);
				}
				return noOfRecordsUpdated;
		}

		public int deleteDataFromTableLoginDetails(String p)
		{
				boolean isError=false;
				int noOfRecordsEffected=0;
				Connection connection=DBUtil.getConnection();
				
				try 
				{
					userBO=new RegistrationDetailsBO();
					noOfRecordsEffected +=userBO.removeRegistrationDetails(connection, p);
					
				} 
				catch (Exception e) 
				{
					
					log.error("Exception Details : deleteDataFromTableLoginDetails "+e);
					isError=true;
					
					
				} 
				finally 
				{
					
					DBUtil.closeConnection(connection,isError);
				}
				return noOfRecordsEffected;
		}
		
		
		
		
		
		
		
}



