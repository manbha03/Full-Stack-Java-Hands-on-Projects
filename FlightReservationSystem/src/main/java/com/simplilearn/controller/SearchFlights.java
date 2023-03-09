package com.simplilearn.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.simplilearn.beans.FlightDetails;
import com.simplilearn.dao.FlightDetailsDao;
import com.simplilearn.dao.FlightDetailsDaoImpl;

/**
 * Servlet implementation class SearchFlights
 */
@WebServlet("/SearchFlights")
public class SearchFlights extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchFlights() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");

		String source = request.getParameter("source");
		String destination = request.getParameter("destination");
		String departOn = request.getParameter("departOn");
		String travellers = request.getParameter("travellers");

		HttpSession session = request.getSession();
		session.setAttribute("source", source);
		session.setAttribute("destination", destination);
		session.setAttribute("departOn", departOn);
		session.setAttribute("travellers", travellers);

		FlightDetailsDao dao = new FlightDetailsDaoImpl();

		List<FlightDetails> flights = dao.searchFlights(source, destination);
		session.setAttribute("flights", flights);
		response.sendRedirect("search-results.jsp");
	}

}
