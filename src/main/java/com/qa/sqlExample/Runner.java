package com.qa.sqlExample;

import java.sql.*;

import com.aq.sql.dbconnection.*;

public class Runner extends db{
	
	
	

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/gamedb?useSSL=false";
	static final String USER = "root";
	static final String PASS = "root";

	public static void main(String[] args) {
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		//db db = new db();
		db name1 = new db();
		
		//
		//ResultSet rs = null;
		try {
			rs = (ResultSet) name1;
			// System.out.println(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while (rs.next()) {
				int id1 = rs.getInt("customerID");
				String name_ = rs.getString("customerName");
				String email_ = rs.getString("email");
				System.out.println("ID: " + id1 + "name: " + name_ + "email: " + email_);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("This is a test:.... "+ name1);
		
		
		
		//InsertGameInfo gameinsert = new InsertGameInfo();
		
		


		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Starting DB Connection..");

		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("DB Connected");

		System.out.println("Starting insert statements");
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String tableName = "gamecustomers";
		
		String name = "'Far Cry 5'";
		//String age = "15";
		String address = "123 a road";
		String pwd = "root";
		String email = "'Piers@p.com'";
		
		

		
		
		// String insertPiers = "(17, \"+ name +\", '123 a road', 'root', 'ab@1.com')";
		// String sqlInsert = "INSERT INTO gamedb.customers VALUES"+""+"
		//String sqlInsert = "INSERT INTO " + tableName + " VALUES(0, " + name + ", '" + age + ");";
		String sqlInsert = "INSERT INTO " + tableName + " VALUES(0, " + name + ", '" + address + "', '" + pwd + "', "+ email + ");";
		try {
			stmt.executeUpdate(sqlInsert);
			//conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Record inserted Successfully");

		System.out.println("Creating Select Statement");
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql2 = "SELECT customerID,customerName,address,passwd,email from " + tableName;
		//ResultSet rs = null;
		try {
			rs = stmt.executeQuery(sql2);
			// System.out.println(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while (rs.next()) {
				int id1 = rs.getInt("customerID");
				String name_ = rs.getString("customerName");
				String email_ = rs.getString("email");
				System.out.println("ID: " + id1 + "name: " + name_ + "email: " + email_);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("Update Statement");
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql3 = "UPDATE gamedb.gamecustomers set customerName='ash' WHERE customerName= 'ash'";
//		String sql3 = "UPDATE gamedb.gamecustomers set customerName='ash' WHERE customerID= 15";
		try {
			stmt.executeUpdate(sql3);
			System.out.println("Record has been updated..");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Delete Record");

		String sql4 = "DELETE FROM gameCustomers WHERE customerID=2";
		try {
			stmt.executeUpdate(sql4);
			System.out.println("Record delete from "+tableName);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
