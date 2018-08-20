package com.moytri.springdemo.dao;

import java.util.List;

import com.moytri.springdemo.entity.Customer;

public interface ICustomerDAO {
	public List<Customer> getCustomers();
	public void saveCustomer(Customer customer);
	public Customer getCustomers(int id);
	public void deleteCustomer(int id);
	public List<Customer> searchCustomers(String theSearchName);
}
