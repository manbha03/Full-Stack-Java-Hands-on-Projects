package com.simplilearn.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.simplilearn.beans.FlightDetails;
import com.simplilearn.dao.FlightDetailsDao;
import com.simplilearn.dao.FlightDetailsDaoImpl;

/**
 * Servlet implementation class AddFlights
 */
@WebServlet("/AddFlights")
public class AddFlights extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddFlights() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String flightNumber = request.getParameter("flightNumber");
		String source = request.getParameter("source");
		String destination = request.getParameter("destination");
		String flightName = request.getParameter("flightName");
		String time = request.getParameter("time");
		String departOn = request.getParameter("departOn");
		String  price =request.getParameter("price");	
		
		FlightDetails flightBean = new FlightDetails(flightNumber,flightName, source, destination,
				departOn, time, price);
		FlightDetailsDao flightDao = new FlightDetailsDaoImpl();
		Integer flightId = flightDao.addFlight(flightBean);
		
		if(flightId !=null) {
			RequestDispatcher rd = request.getRequestDispatcher("admin-dashboard.jsp");
			rd.include(request, response);
			
			out.print("<script>window.alert('Flight Added Successfully')</script>");
		}
		
	}

}
