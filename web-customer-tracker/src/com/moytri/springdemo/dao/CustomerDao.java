package com.moytri.springdemo.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.moytri.springdemo.entity.Customer;

@Repository
public class CustomerDao implements ICustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;
		
	@Override
	@Transactional
	public List<Customer> getCustomers() {

		//get the current hibernate session
		Session session = sessionFactory.getCurrentSession();
		
		//create query
		Query<Customer> query = session.createQuery("from Customer", Customer.class);
		
		//get the result from executing query
		List<Customer> result = query.getResultList();
		
		return result;
	}

}
