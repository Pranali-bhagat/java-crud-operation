package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Delete {
	
	private static final String DELETE_QUERY = "DELETE FROM STUD WHERE ID=?";

	public static void main (String [] args) {
		Scanner scn = new Scanner(System.in);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pranali","root","Pranali@08");
				PreparedStatement ps = con.prepareStatement(DELETE_QUERY);){
			    
				System.out.println("Enter student id which to delete : ");
				int id = scn.nextInt();
									
				ps.setInt(1, id);
				
				int count = ps.executeUpdate();
				
				if(count==0) {
					System.out.println("record is not Deleted");
				}else {
					System.out.println("record is deleted");
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
