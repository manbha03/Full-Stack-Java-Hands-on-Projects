package com.simplilearn.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "flightdetails")
public class FlightDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int flightId;
	private String flightNumber;
	private String flightName;
	@Column(name = "source")
	private String source;
	@Column(name = "destination")
	private String destination;
	private String departOn;
	private String time;
	private String price;
	public FlightDetails() {
	}
	
	public FlightDetails(String flightNumber, String flightName, String source, String destination, String departOn,
			String time, String price) {
		super();
		this.flightNumber = flightNumber;
		this.flightName = flightName;
		this.source = source;
		this.destination = destination;
		this.departOn = departOn;
		this.time = time;
		this.price = price;
	}

	
	public int getFlightId() {
		return flightId;
	}

	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getFlightName() {
		return flightName;
	}

	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getDepartOn() {
		return departOn;
	}

	public void setDepartOn(String departOn) {
		this.departOn = departOn;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "FlightDetails [flightId=" + flightId + ", flightNumber=" + flightNumber + ", flightName=" + flightName
				+ ", source=" + source + ", destination=" + destination + ", departOn=" + departOn + ", time=" + time
				+ ", price=" + price + "]";
	}

	
}
