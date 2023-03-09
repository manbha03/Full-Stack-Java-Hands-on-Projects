package com.simplilearn.dao;

import java.util.List;

import com.simplilearn.beans.FlightDetails;

public interface FlightDetailsDao {

	Integer addFlight(FlightDetails flight);
	List<FlightDetails> searchFlights(String source, String destination);
	List<FlightDetails> getAllFlights();
	List<FlightDetails> viewAirline();
}
