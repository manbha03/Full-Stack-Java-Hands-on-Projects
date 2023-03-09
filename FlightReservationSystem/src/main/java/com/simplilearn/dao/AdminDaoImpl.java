package com.simplilearn.dao;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.simplilearn.beans.Admin;

public class AdminDaoImpl implements AdminDao {

	private SessionFactory sessionFactory;

	public AdminDaoImpl() {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
		sessionFactory = meta.getSessionFactoryBuilder().build();
	}

	@Override
	public Integer addAdmin(Admin admin) {

		Integer adminId = null;
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		adminId = (Integer) session.save(admin);
		transaction.commit();
		session.close();
		return adminId;
	}

	@Override
	public Admin searchByEmail(String email) {
		Session session = sessionFactory.openSession();
		String hql = "From Admin where email = :email";
		TypedQuery<Admin> query = session.createQuery(hql);
		query.setParameter("email", email);
		Admin admin = query.getSingleResult();
		session.close();
		return admin;
	}

	@Override
	public boolean validate(Admin admin) {
		boolean isValid = false;
		String email = admin.getEmail();
		String password = admin.getPassword();
		Admin adminDb = searchByEmail(email);

		if (email.equals(adminDb.getEmail()) && password.equals(adminDb.getPassword())) {
			isValid = true;
		}
		return isValid;
	}

	@Override
	public void updatePassword(String email, String password) {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		Admin admin = searchByEmail(email);
		admin.setPassword(password);

		session.update(admin);
		transaction.commit();
		session.close();
	}
}
