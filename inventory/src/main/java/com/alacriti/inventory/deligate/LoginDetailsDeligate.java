package com.alacriti.inventory.deligate;	

import java.sql.Connection;
import java.util.List;

import com.alacriti.inventory.bo.UserDetailsBO;
import com.alacriti.inventory.db.DBUtil;
import com.alacriti.inventory.models.LoginDetailsModel;



public class LoginDetailsDeligate {
		
	
		UserDetailsBO userBO=null;
		
		public List<LoginDetailsModel> getAllDataFromLoginDetailsTable(){
			boolean isError=false;
			Connection connection=DBUtil.getConnection();
			List<LoginDetailsModel> list=null;
			try {	
				userBO=new UserDetailsBO();
				list=userBO.getAllDataFromLoginDetailsBO(connection);			
				
			} catch (Exception e) {
				
				isError=true;
				System.out.println("Exception Details  :" + e);
				return list;
				
			} finally {
				
				DBUtil.closeConnection(connection,isError);
			}
			return list;
			
		}

		public int addDataToTableLoginDetails(LoginDetailsModel p[])
		{
			boolean isError=false;
			int noOfRecordsUpdated=0;

				Connection connection=DBUtil.getConnection();
				
				try {
					userBO=new UserDetailsBO();
					noOfRecordsUpdated=userBO.addDataToLoginDetailsBO(connection, p);
					
					
					
				} catch (Exception e) {
					
					System.out.println("Error  :" + e.getMessage());
					isError=true;
					
					
				} finally {
					
					DBUtil.closeConnection(connection,isError);
				}
				return noOfRecordsUpdated;
		}
		

		public void updateDataToTableLoginDetails(LoginDetailsModel[] p)
		{			
			boolean isError=false;
				
				Connection connection=DBUtil.getConnection();
				
				try 
				{	
					userBO=new UserDetailsBO();
					userBO.updateDataToLoginDetailsBO(connection, p);
					
				} catch (Exception e) {
					
					System.out.println("Error  :" + e.getMessage());
					isError=true;
					
				} finally {
					
					DBUtil.closeConnection(connection,isError);
				}
		}

		public void deleteDataFromTableLoginDetails(String p)
		{
			boolean isError=false;
				
				Connection connection=DBUtil.getConnection();
				
				try 
				{
					userBO=new UserDetailsBO();
					userBO.deleteDataFromLoginDetailsBO(connection, p);
					
				} 
				catch (Exception e) 
				{
					
					System.out.println("Error  :" + e.getMessage());
					isError=true;
					
					
				} 
				finally 
				{
					
					DBUtil.closeConnection(connection,isError);
				}
		}
		
		
		
		
		
		
		
}



