package com.aq.sql.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class db {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/gamedb?useSSL=false";
	static final String USER = "root";
	static final String PASS = "root";

	Connection conn = null;
	Statement stmt = null;
	
	public db() {
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(
		ClassNotFoundException e11)
		{
			// TODO Auto-generated catch block
			e11.printStackTrace();
		}System.out.println("Starting DB Connection..");

		try
		{
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
		}catch(
		SQLException e111)
		{
			// TODO Auto-generated catch block
			e111.printStackTrace();
		}
		System.out.println("DB Connected");
		
		System.out.println("Starting insert statements");
		try
		{
			stmt = conn.createStatement();
		}catch(
		SQLException e11111)
		{
			// TODO Auto-generated catch block
			e11111.printStackTrace();
		}
	}
	
	public void createCustomer(String name, String address, String email, String password) {
		String query = "INSERT INTO gamecustomers VALUES(0,'"+name+"','"+address+"','"+email+"','"+password+"')";
		try {
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updateCustomer(String name, String address, String email, String password) {
		String query = "UPDATE gamecustomers SET customerName='ash123' WHERE customerName= 'ash'";
	}
	
	public void deleteCustomer(String name, String address, String email, String password) {
		String query = "DELETE FROM gamecustomers WHERE customerName='ash123' WHERE customerName= 'ash'";
	}
	
	public void createGame(String name, String age, String rating) {
		String query = "INSERT INTO gametable VALUES(0,'"+name+"','"+age+"','"+rating+"')";
		try {
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updateGame(String name, String address, String email, String password) {
		String query = "UPDATE gametable SET game_name='ash123' WHERE game_name= 'ash'";
	}
	
	public void deleteGame(String name, String address, String email, String password) {
		String query = "DELETE FROM gametable WHERE game_name='ash123' WHERE game_name= 'ash'";
	}
	
	
	public void createOrder(String name, String dateOrdered, String price) {
		String query = "INSERT INTO gameorders VALUES(0,'"+name+"','"+dateOrdered+"','"+price+"')";
		try {
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updateOrder(String name, String dateOrdered, String price) {
		String query = "UPDATE gameorders SET totalamount='10.00' WHERE customerID= 5";
	}
	
	public void deleteOrder(String name, String dateOrdered, String price) {
		String query = "DELETE FROM gameorders WHERE totalamount='10.00' WHERE customerID= 5";
		System.out.println("Order has been deleted from...");
	}

	


//	int id = 0;
//	String gameName = "'Far Cry 5'";
//	int rating = 15;
//	
//	String sqlInsert = "INSERT INTO " + tableNameGame + " VALUES("+id+", "+name+",  "+ rating+ ");";
//	try {
//		stmt.executeUpdate(sqlInsert);
//		//conn.close();
//	} catch (SQLException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	System.out.println("Record sucessful");
//
//	try
//	{
//		stmt = conn.createStatement();
//	}catch(
//	SQLException e23)
//	{
//		// TODO Auto-generated catch block
//		e23.printStackTrace();
//	}
//	String sql2 = "SELECT gameID,game_name,rating from " + tableNameGame;
//	ResultSet rs = null;try
//	{
//		rs = stmt.executeQuery(sql2);
//		// System.out.println(rs);
//	}catch(
//	SQLException e)
//	{
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}try
//	{
//		while (rs.next()) {
//			int gameid = rs.getInt("gameID");
//			String gameName = rs.getString("game_name");
//			String email_ = rs.getString("rating");
//			System.out.println("Game ID: " + gameid + "name: " + gameName + "rating: " + rating);
//		}
//	}catch(
//	SQLException e1)
//	{
//		e11.printStackTrace();
//	}

}
