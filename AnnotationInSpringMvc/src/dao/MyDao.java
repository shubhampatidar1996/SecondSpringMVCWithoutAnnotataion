package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.EmployeeBean;
  public class MyDao {
		public Connection start()
		{
			Connection con=null;
			try {
				Class.forName("com.mysql.jdbc.Driver");
				 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/spring","root","root");
			}catch(Exception e)
			{
				System.out.println(e);
			}
			return con;
		}
		
		
		
		public int loginCheck(String uid,String pwd)
		{
			int x=0;
			
			try {
				Connection con=start();
				PreparedStatement ps=con.prepareStatement("select * from login where uid=? and password=?");
				ps.setString(1, uid);
				ps.setString(2, pwd);
				ResultSet rs=ps.executeQuery();
				
				if(rs.next())
					x=1;
				con.close();
				}catch(  SQLException e)
			{
					System.out.println(e);
			}
			
			return x;
		}
		public int insert(EmployeeBean e)
		{ 
			int x=0;
			
			try {
				
				Connection con=start();
				PreparedStatement ps1=con.prepareStatement("insert into employee (name,address,salary)values(?,?,?)");
			    
			    ps1.setString(1,e.getName());
			    ps1.setString(2, e.getAddress());
			    ps1.setInt(3,e.getSalary());
			   
			    x=ps1.executeUpdate();
			    con.close();
			    }catch(Exception w)
			{
			    	System.out.println(w);
			}
			
		return x;
		}
		  }
