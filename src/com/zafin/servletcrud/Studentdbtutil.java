package com.zafin.servletcrud;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class Studentdbtutil {
	private static DataSource datasource;

	public Studentdbtutil(DataSource datasource) {
		this.datasource = datasource;
	}
	
	public List<Student> getStudents() throws Exception{
		List<Student> students = new ArrayList<>();
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			myConn = datasource.getConnection();
			String sql = "Select * from student order by last_name";
			myStmt = myConn.createStatement();
			myRs = myStmt.executeQuery(sql);
			while(myRs.next()) {
				int id = myRs.getInt("id");
				String fname = myRs.getString("first_name");
				String lname = myRs.getString("last_name");
				String email = myRs.getString("email");
				students.add(new Student(id,fname,lname,email));
				System.out.println(fname);
			}
			return students;	
		}finally {
			System.out.println("Customer List generated");
		}
	}
}
