package com.simplilearn.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class TravellerDetails
 */
@WebServlet("/TravellerDetails")
public class TravellerDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TravellerDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String pname = request.getParameter("pname");
		String pemail = request.getParameter("pemail");
		String phone = request.getParameter("phone");

		HttpSession session = request.getSession();
		session.setAttribute("pname", pname);
		session.setAttribute("pemail", pemail);
		session.setAttribute("phone", phone);

		response.sendRedirect("card-details.jsp");
	}

}
