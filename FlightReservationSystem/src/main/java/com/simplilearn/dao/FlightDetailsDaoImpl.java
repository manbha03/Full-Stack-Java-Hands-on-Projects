package com.simplilearn.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.simplilearn.beans.FlightDetails;

public class FlightDetailsDaoImpl implements FlightDetailsDao {

	private SessionFactory sessionFactory;
	FlightDetails flight = null;

	public FlightDetailsDaoImpl() {
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta = new MetadataSources(registry).getMetadataBuilder().build();
		sessionFactory = meta.getSessionFactoryBuilder().build();
	}
	
	@Override
	public Integer addFlight(FlightDetails flight) {

		Integer flightId = null;
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		flightId = (Integer) session.save(flight);
		transaction.commit();
		session.close();
		return flightId;
	}

	@Override
	public List<FlightDetails> searchFlights(String source, String destination) {

		List<FlightDetails> flight = null;
		Session session = sessionFactory.openSession();
		String query = "FROM FlightDetails where source = :source AND destination = :destination";
		
		TypedQuery<FlightDetails> typedQuery = session.createQuery(query);
		typedQuery.setParameter("source", source);
		typedQuery.setParameter("destination", destination);
		flight = typedQuery.getResultList();
		session.close();
		return flight;

	}
	@Override
	public List<FlightDetails> getAllFlights() {
		List<FlightDetails> flight = null;
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		String query = "From FlightDetails";

		TypedQuery<FlightDetails> typedQuery = session.createQuery(query);
		flight = typedQuery.getResultList();
		session.close();
		return flight;
	}

	@Override
	public List<FlightDetails> viewAirline() {
		List<FlightDetails> flights = null;
		Session session = sessionFactory.openSession();	
		String query = "From FlightDetails where flightName = :flightName";
		
		TypedQuery<FlightDetails> typeQuery = session.createQuery(query);
		typeQuery.setParameter("flightName", flights);
		flights = typeQuery.getResultList();
		session.close();
		return flights;
	}

}
