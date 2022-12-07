package com.test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Insert {
	
	private static final String INSERT_QUERY = "INSERT INTO STUD(ID,NAME,ADDRESS,AGE) VALUES (?,?,?,?)";
	
	public static void main (String [] args) {
		Scanner scn = new Scanner(System.in);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pranali","root","Pranali@08");
				PreparedStatement ps = con.prepareStatement(INSERT_QUERY);){
			    
				System.out.println("Enter student id: ");
				int id = scn.nextInt();
				
				System.out.println("Enter student name : ");
				String name = scn.next();
				
				System.out.println("Enter student address : ");
				String address = scn.next();
				
				System.out.println("Enter student age : ");
				int age = scn.nextInt();
							
				ps.setInt(1, id);
				ps.setString(2, name);
				ps.setString(3, address);
				ps.setInt(4, age);
				
				int count = ps.executeUpdate();
				
				if(count==0) {
					System.out.println("record is not registered");
				}else {
					System.out.println("record is registered");
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
