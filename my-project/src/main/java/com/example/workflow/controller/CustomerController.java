package com.example.workflow.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.workflow.model.Customer;
import com.example.workflow.service.CamundaService;
import com.example.workflow.service.CustomerService;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class CustomerController{

	@Autowired
	private CustomerService custService;
	
	@Autowired
	CamundaService camundaService;
	
	@PostMapping(value = "/startCamunda")
	public void getStarted(@RequestBody String customerName) {
		camundaService.startProcessBySendingId(customerName);
	}
	
	@GetMapping(value = "/customers")
	public List<Customer> getAllCustomerDetails() {
		return custService.getAllCustomerDetails();
	}

	@GetMapping(value = "/customers/{customerName}")
	public Customer getCustomerDetails(@PathVariable(value = "customerName") String customerName) {
		return custService.getCustomerDetails(customerName);
	}
	
	@PostMapping(value = "/add/customers")
	public String postCustomerDetails(@RequestBody Customer customer) {
		return custService.postCustomerDetails(customer);
	}
	
	@GetMapping(value = "/delete/customers/{customerName}")
	public String deleteCustomerDetails(@PathVariable(value = "customerName") String customerName) {
		return custService.deleteCustomerDetails(customerName);
	}
	
}
