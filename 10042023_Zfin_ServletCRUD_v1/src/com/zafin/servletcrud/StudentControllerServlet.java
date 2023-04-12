package com.zafin.servletcrud;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import javax.annotation.Resource;

/**
 * Servlet implementation class StudentControllerServlet
 */
@WebServlet("/StudentControllerServlet")
public class StudentControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Studentdbtutil studentdb = null;
	@Resource(name = "jdbc/studtracker")
	private DataSource datasource;

	/**
	 * Default constructor.
	 */
	public StudentControllerServlet() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		try {
			studentdb = new Studentdbtutil(datasource);
		} catch (Exception e) {
			throw new ServletException(e);
		}

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		try {
			String theCommand = request.getParameter("command");
			if (theCommand == null) {
				theCommand = "LIST";
			}
			switch (theCommand) {
			case "LIST":
				ListStudents(request, response);
				break;
			case "DELETE":
				DeleteStudents(request, response);
				break;
			case "LOAD":
				LoadStudents(request, response);
				break;
			case "UPDATE":
				UpdateStudents(request, response);

				break;
			default:
				ListStudents(request, response);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void UpdateStudents(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String sID = request.getParameter("id");
		String fName = request.getParameter("fname");
		String lName = request.getParameter("lname");
		String eMail = request.getParameter("email");
		/*
		 * System.out.println(lName); System.out.println(sID);
		 */
		Studentdbtutil.update(sID, fName, lName, eMail);
		ListStudents(request, response);
		

	}

	private void LoadStudents(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		// TODO Auto-generated method stub
		String sId = request.getParameter("studentId");
		int id = Integer.parseInt((String) sId);
		Student student = Studentdbtutil.loadstudent(id);
		request.setAttribute("DETAILS", student);

		// send to jsp page
		RequestDispatcher dispatcher = request.getRequestDispatcher("/update.jsp");
		dispatcher.forward(request, response);

	}

	private void DeleteStudents(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	private void ListStudents(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub

		// get students from db util
		List<Student> students = studentdb.getStudents();

		// add students to request
		request.setAttribute("STUDENT_LIST", students);

		// send to jsp page
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-students.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		addStudents(request, response);
		doGet(request, response);
	}

	private void addStudents(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		
		}
	}

}
