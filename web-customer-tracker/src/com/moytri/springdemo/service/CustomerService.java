package com.moytri.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.moytri.springdemo.dao.ICustomerDAO;
import com.moytri.springdemo.entity.Customer;

@Service
public class CustomerService implements ICustomerService {

	//need to inject the DAO in to this Service
	@Autowired
	private ICustomerDAO customerDAO;
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {		
		//get customers from the Service
		return customerDAO.getCustomers();
	}

	@Override
	@Transactional
	public void saveCustomer(Customer customer) {
		customerDAO.saveCustomer(customer);
	}

	@Override
	@Transactional
	public Customer getCustomers(int id) {
		return customerDAO.getCustomers(id);
	}

	@Override
	@Transactional
	public void deleteCustomer(int id) {		
		customerDAO.deleteCustomer(id);		
	}

    @Override
    @Transactional
    public List<Customer> searchCustomers(String theSearchName) {

        return customerDAO.searchCustomers(theSearchName);
    }

}
