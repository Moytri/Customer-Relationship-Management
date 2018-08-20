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
	public List<Customer> getCustomers() {

		//get the current hibernate session
		Session session = sessionFactory.getCurrentSession();
		
		//create query -- sort by last Name
		Query<Customer> query = session.createQuery("from Customer order by lastName", 
				                                    Customer.class);
		
		//get the result from executing query
		List<Customer> result = query.getResultList();
		
		return result;
	}

	@Override
	public void saveCustomer(Customer customer) {

		//get the current hibernate session
		Session session = sessionFactory.getCurrentSession();
		
		//save the customer into db
		session.saveOrUpdate(customer);
	}

	@Override
	public Customer getCustomers(int id) {
		
		//get the current hibernate session
		Session session = sessionFactory.getCurrentSession();
		
		Query query = session.createQuery("from Customer where id=:id");
		query.setParameter("id", id);
		
		Customer customer = (Customer) query.getSingleResult();
		
		return customer;
	}

	@Override
	public void deleteCustomer(int id) {
		
		//get the current hibernate session
		Session session = sessionFactory.getCurrentSession();
		
		//delete the Object with the primary key id
		Query query = session.createQuery("delete from Customer where id=:id");
		query.setParameter("id", id);	
		
		query.executeUpdate();
	}

	@Override
    public List<Customer> searchCustomers(String theSearchName) {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        
        Query theQuery = null;
        
        //
        // only search by name if theSearchName is not empty
        //
        if (theSearchName != null && theSearchName.trim().length() > 0) {

            // search for firstName or lastName ... case insensitive
            theQuery =currentSession.createQuery("from Customer where lower(firstName) like :theName or lower(lastName) like :theName", Customer.class);
            theQuery.setParameter("theName", "%" + theSearchName.toLowerCase() + "%");

        }
        else {
            // theSearchName is empty ... so just get all customers
            theQuery =currentSession.createQuery("from Customer", Customer.class);            
        }
        
        // execute query and get result list
        List<Customer> customers = theQuery.getResultList();
                
        // return the results        
        return customers;
        
    }

}
