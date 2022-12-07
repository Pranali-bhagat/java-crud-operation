package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Select {

private static final String SELECT_QUERY = "SELECT ID, NAME, ADDRESS, AGE FROM STUD" ;
	
	public static void main (String [] args) {
		Scanner scn = new Scanner(System.in);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pranali","root","Pranali@08");
				PreparedStatement ps = con.prepareStatement(SELECT_QUERY);){
			    
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getInt(4));
				}
				
		}catch(SQLException se ) {
			System.out.println(se.getMessage());
			se.printStackTrace();
		} catch(Exception e ) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
