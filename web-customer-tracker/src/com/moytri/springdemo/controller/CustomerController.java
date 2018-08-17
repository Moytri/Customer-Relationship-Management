package com.moytri.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.moytri.springdemo.entity.Customer;
import com.moytri.springdemo.service.ICustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	//need to inject the Service in to this Controller
	@Autowired
	private ICustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomers(Model model) {
		
		//get customers from the Service
		List<Customer> customers = customerService.getCustomers();
		
		//add them to the MVC model
		model.addAttribute("customers", customers);
		
		return "list-customers";
	}
	
	
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		
		//create model attribute to bind from data
		Customer customer = new Customer();
		
		model.addAttribute("customer", customer);
		
		return "customer-form";
	}
	
	
	//store customer from form data
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {
		
		//save the customer using service
		customerService.saveCustomer(customer);
		return "redirect:/customer/list";
	}

}
