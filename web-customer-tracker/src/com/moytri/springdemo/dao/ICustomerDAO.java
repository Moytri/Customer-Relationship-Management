package com.moytri.springdemo.dao;

import java.util.List;

import com.moytri.springdemo.entity.Customer;

public interface ICustomerDAO {
	public List<Customer> getCustomers();
}
