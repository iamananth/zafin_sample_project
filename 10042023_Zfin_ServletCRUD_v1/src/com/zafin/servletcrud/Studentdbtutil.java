package com.zafin.servletcrud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class Studentdbtutil {
	private static DataSource datasource;

	public Studentdbtutil(DataSource datasource) {
		this.datasource = datasource;
	}

	private static void close(Connection myConn, Statement myStmt, ResultSet myRs) {
		// TODO Auto-generated method stub

		try {

			if (myRs != null) {
				myRs.close();
			}
			if (myConn != null) {
				myConn.close();
			}
			if (myStmt != null) {
				myStmt.close();
			}

		} catch (Exception e) {

		}

	}

	public List<Student> getStudents() throws Exception {
		List<Student> students = new ArrayList<>();
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;

		try {
			myConn = datasource.getConnection();
			String sql = "Select * from student order by last_name";
			myStmt = myConn.createStatement();
			myRs = myStmt.executeQuery(sql);
			while (myRs.next()) {
				int id = myRs.getInt("id");
				String fname = myRs.getString("first_name");
				String lname = myRs.getString("last_name");
				String email = myRs.getString("email");
				students.add(new Student(id, fname, lname, email));
			}
			return students;
		} finally {
			
			close(myConn, myStmt, myRs);
		}
	}

	public static void addStudents(Student student) throws Exception {
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		myConn = datasource.getConnection();
		PreparedStatement pgStmt = myConn
				.prepareStatement("Insert into student(first_name,last_name,email)values(?,?,?)");
		pgStmt.setString(1, student.getFirstName());
		pgStmt.setString(2, student.getLastName());
		pgStmt.setString(3, student.getEmail());

		pgStmt.executeUpdate();
		close(myConn, myStmt, myRs);
		
	}

	public static void DeleteStudent(String studId) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	public static Student loadstudent(int id) throws SQLException {
		// TODO Auto-generated method stub
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		Student student=null;
		myConn = datasource.getConnection();
		PreparedStatement pgStmt = myConn
				.prepareStatement("select * from student where id=?");
		pgStmt.setInt(1,id);
		myRs=pgStmt.executeQuery();
		while(myRs.next()) {
			int sId=myRs.getInt("id");
			String fname=myRs.getString("first_name");
			String lname=myRs.getString("last_name");
			String mail=myRs.getString("email");
			student = new Student(sId,fname,lname,mail);
			
			
		}
		close(myConn,myStmt,myRs);
		
		return student;
	}

	public static void update(String sID, String fName, String lName, String eMail) throws SQLException {
		// TODO Auto-generated method stub
		int id=Integer.parseInt((String) sID);
		//System.out.println(id);
		Connection myConn = null;
		PreparedStatement myStmt = null;
		myConn = datasource.getConnection();
		PreparedStatement pgStmt = myConn
				.prepareStatement("UPDATE student SET first_name = ?, last_name =?,email=? WHERE id=?");
		pgStmt.setString(1,fName);
		pgStmt.setString(2,lName);
		pgStmt.setString(3,eMail);
		pgStmt.setInt(4,id);
		pgStmt.executeUpdate();
		
	}

}
