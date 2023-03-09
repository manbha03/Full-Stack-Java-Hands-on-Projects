package com.simplilearn.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.simplilearn.beans.Admin;
import com.simplilearn.dao.AdminDao;
import com.simplilearn.dao.AdminDaoImpl;

/**
 * Servlet implementation class ValidateUser
 */
@WebServlet("/ValidateUser")
public class ValidateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidateUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		Admin admin = new Admin(email, password);
		AdminDao adminDao = new AdminDaoImpl();
		
		boolean isCredentialsValid = adminDao.validate(admin);
		
		if(isCredentialsValid) {
			HttpSession session = request.getSession();
			
			session.setAttribute("email", admin.getEmail());
			session.setAttribute("password", admin.getPassword());			
			response.sendRedirect("admin-dashboard.jsp");
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("admin-homepage.jsp");
			rd.include(request, response);
		
			out.print("<header style='color:red; margin-left:7%'> Invalid email or password! </header>");			
		}
	}

}
