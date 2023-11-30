package databaseconnection;

import java.sql.*;

public class practice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;

		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

		} catch (ClassNotFoundException ex) {

			System.out.println("problem loading driver");
			ex.printStackTrace();
		}

		try {
			String dbName = "employee.accdb";
			String dbURL = "jdbc:ucanaccess://" + dbName;

			conn = DriverManager.getConnection(dbURL);
			stat = conn.createStatement();
			String query;
			// String query= "INSERT INTO EMP (EName,Salary)" + "values ('abc', 950000)";
			// stat.executeUpdate(query);

			query = "UPDATE EMP SET SALARY = 120000 " + "where EName = 'burak'";
			stat.executeUpdate(query);
			
			query="delete from emp where Ename='mahmut'";
			stat.executeUpdate(query);
			
			rs = stat.executeQuery("SELECT * FROM EMP");
			int id;
			String name;
			double sal;
			while (rs.next()) {
				id = rs.getInt(1);
				name = rs.getString(2);
				sal = rs.getDouble(3);
				System.out.println(id + " " + name + " " + sal);
			}

		} catch (SQLException ex) {
			System.out.println("problem with database");
		} finally {

			try {
				if (conn != null) {
					rs.close();
					stat.close();
					conn.close();
				}
			} catch (SQLException ex) {

				ex.printStackTrace();
			}

		}

	}

}
