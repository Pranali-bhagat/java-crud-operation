package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Update {

	//private static final String UPDATE_QUERY = "UPDATE STUD SET NAME=? WHERE ID=?";
	private static final String UPDATE_QUERY = "UPDATE STUD SET ADDRESS=? WHERE ID=?";
	public static void main (String [] args) {
		Scanner scn = new Scanner(System.in);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pranali","root","Pranali@08");
				PreparedStatement ps = con.prepareStatement(UPDATE_QUERY);){
			    
				System.out.println("Enter student id: ");
				int id = scn.nextInt();
				
				//System.out.println("Enter Updated name : ");
				//String name = scn.next();
				
				System.out.println("Enter Updated address : ");
				String address = scn.next();
				
				//ps.setString(1, name);
				ps.setString(1, address);
				ps.setInt(2, id);
				
								
				int count = ps.executeUpdate();
				
				if(count==0) {
					System.out.println("record is not updated");
				}else {
					System.out.println("record is updated");
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
