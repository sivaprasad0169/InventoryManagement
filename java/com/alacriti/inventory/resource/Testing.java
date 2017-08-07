package com.alacriti.inventory.resource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//import javax.activation.DataSource;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlRootElement;

@Path("/test")
@Produces(MediaType.TEXT_PLAIN)
public class Testing {
	

	@GET
	public String testing() {

		DataSource dataSource = null;
		Connection connection = null;
		Statement statement = null;
		ResultSet result = null;
		String dbName;
		try {
			dataSource = (DataSource) new InitialContext()
					.lookup("java:jboss/datasources/TRAINEEE");
			connection = dataSource.getConnection();
			statement = connection.createStatement();
			result = statement.executeQuery("select * from person;");
			result.absolute(1);
			dbName = connection.getMetaData().getDatabaseProductName();
			return "ProductName " + dbName + "Result set data "
					+ result.getInt(1);
		} catch (Exception e) {
			System.out.println("Error  :" + e.getMessage());
			return "Exception occured";
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	
	@POST
	@Path("/post")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Person> postData(Person p[]){
		
		addDataToTablePerson(p);
		return showAllDataFromPersonTable();
	}
	
	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Person> allData() {
		
		return showAllDataFromPersonTable();
		
	}
	@DELETE
	@Path("/delete")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Person> deleteRowFromPersonTable(int id){
		deleteRecordFromPersonTable(id);
		return showAllDataFromPersonTable();
		
	}
	@POST
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Person> updateData(Person p[]){
		updateDateIntoPersonTable(p);
		return showAllDataFromPersonTable();
		
	}
	
	
	public void addDataToTablePerson(Person p[]){
		
		DataSource dataSource = null;
		Connection connection = null;
		PreparedStatement preparedStatement=null;
		try {
			
			dataSource = (DataSource) new InitialContext()
					.lookup("java:jboss/datasources/TRAINEEE");
			
			connection = dataSource.getConnection();
			connection.setAutoCommit(false);
			
			preparedStatement=connection.prepareStatement("insert into person values(?,?,?,?);");
			
			for(int i=0;i<(p.length);i++){
				preparedStatement.setInt(1, p[i].id);
				preparedStatement.setInt(3, p[i].age);
				preparedStatement.setString(2, p[i].personName);
				preparedStatement.setString(4, p[i].city);
				
				preparedStatement.executeUpdate();
			}
			connection.commit();
		} catch (Exception e) {
			
			System.out.println("Error  :" + e.getMessage());
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
		} finally {
			
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
	}
	
	
	
	public List<Person> showAllDataFromPersonTable(){
		DataSource dataSource = null;
		Connection connection = null;
		Statement statement = null;
		ResultSet result = null;
		List<Person> list=null;
		try {
			
			dataSource = (DataSource) new InitialContext()
					.lookup("java:jboss/datasources/TRAINEEE");
			
			connection = dataSource.getConnection();
			connection.setAutoCommit(false);
			
			statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			
			result = statement.executeQuery("select * from person;");
			
			list=new ArrayList<Person>();
			
			while (result.next()) {
				list.add(new Person(result.getInt(1),result.getString(2),result.getInt(3),result.getString(4)));
			}
			connection.commit();
		} catch (Exception e) {
			
			System.out.println("Error  :" + e.getMessage());
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return list;
			
		} finally {
			
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return list;
		
	}
	
	
	public String deleteRecordFromPersonTable(int id){
		
		DataSource dataSource = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int noOfRecordAffected=0;
		try {
			
			dataSource = (DataSource) new InitialContext()
					.lookup("java:jboss/datasources/TRAINEEE");
			
			connection = dataSource.getConnection();
			connection.setAutoCommit(false);
			
			preparedStatement=connection.prepareStatement("delete from person where id=?;");
			
			
			preparedStatement.setInt(1, id);
			noOfRecordAffected=preparedStatement.executeUpdate();
			connection.commit();
			
		} catch (Exception e) {
			
			System.out.println("Error  :" + e.getMessage());
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return noOfRecordAffected+"records Effected";
			
		} finally {
			
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return noOfRecordAffected+"records Effected";
		
	}
	
	
	
	
	
	public String updateDateIntoPersonTable(Person p[]){
		
		DataSource dataSource = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int noOfRecordAffected=0;
		try {
			
			dataSource = (DataSource) new InitialContext()
					.lookup("java:jboss/datasources/TRAINEEE");
			
			connection = dataSource.getConnection();
			connection.setAutoCommit(false);
			preparedStatement=connection.prepareStatement("update person set name=?,age=?,country=? where id=?;");
			
			for(int i=0;i<p.length;i++)
			{
				preparedStatement.setInt(4, p[i].id);
				preparedStatement.setString(1, p[i].personName);
				preparedStatement.setInt(2, p[i].age);
				preparedStatement.setString(3, p[i].city);
				
				noOfRecordAffected=preparedStatement.executeUpdate();
			}
			connection.commit();
			
		} catch (Exception e) {
			
			System.out.println("Error  :" + e.getMessage());
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return noOfRecordAffected+"records Effected";
			
			
			
		} finally {
			
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return noOfRecordAffected+"records Effected";
		
	}
	
	
	

}




@XmlRootElement
class Person{
	
	 int id,age,nullValue;
	 String personName,city;
	Person(int id,String Name,int age,String city){
		this.id=id;
		this.personName=Name;
		this.age=age;
		this.city=city;
	}
	Person(){}
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String Name) {
		this.personName = Name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
}
