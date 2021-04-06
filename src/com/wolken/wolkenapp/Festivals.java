package com.wolken.wolkenapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class Festivals {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con = null;
		Statement statement = null;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter id");
		int id = sc.nextInt();
		System.out.println("Enter festive name");
		String name = sc.next();
		System.out.println("Enter month");
		String month = sc.next();
		System.out.println("days");
		int days = sc.nextInt();
		//Class.forName(className)
		
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/wolken?user=root&password=Leela12345$$");
			statement=con.createStatement();
		//	statement.executeUpdate("insert into festivals values(6, 'Ugadi','apr', 1)");
		//	statement.executeUpdate("insert into festivals values(7 , 'navaratri','oct', 9)");
	//		statement.executeUpdate("insert into festivals values(3, 'christmas','dec', 2)");
		//	statement.executeUpdate("insert into festivals values(4, 'shiva ratri','march', 1)");
			PreparedStatement ps = con.prepareStatement("insert into festivals values(?,?,?,?)");
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setString(3, month);
			ps.setInt(4, days);
			ps.executeUpdate();
			//fetching the data
			ResultSet rs = statement.executeQuery("select * from festivals;");
			while(rs.next()) {
				int festive_id = rs.getInt("id");
				String festive_name = rs.getString("name");
				String festive_month = rs.getString("month");
			  int no_of_days = rs.getInt("no_of_days");
			  System.out.println(festive_id + festive_name + festive_month + no_of_days);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		}
		if(con !=null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	
		

	}

}
