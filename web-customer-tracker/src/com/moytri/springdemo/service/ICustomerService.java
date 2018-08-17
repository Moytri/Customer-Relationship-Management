package com.moytri.springdemo.service;

import java.util.List;

import com.moytri.springdemo.entity.Customer;

public interface ICustomerService {
	public List<Customer> getCustomers();
	public void saveCustomer(Customer customer);
}
