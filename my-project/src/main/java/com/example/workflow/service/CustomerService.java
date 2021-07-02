package com.example.workflow.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.workflow.model.Customer;

@Service
public class CustomerService {

	Map<String, Customer> customerDetails = new HashMap<>();

	CustomerService() {
		Customer customer1 = new Customer();
		Customer customer2 = new Customer();
		customer1.setName("David");
		customer1.setId(001);
		customer1.setCompany("Company1");
		customer1.setContact(01234);
		customer1.setAddress("UK");
		customer2.setName("Bart");
		customer2.setId(002);
		customer2.setCompany("Company2");
		customer2.setContact(56789);
		customer2.setAddress("CN");
		customerDetails.put(customer1.getName(), customer1);
		customerDetails.put(customer2.getName(), customer2);
	}

	public List<Customer> getAllCustomerDetails() {
		return customerDetails.values().stream().collect(Collectors.toList());
	}

	public Customer getCustomerDetails(String customerName) {
		Customer customer = new Customer();
		for (Entry<String, Customer> entry : customerDetails.entrySet()) {
			if (entry.getKey().equalsIgnoreCase(customerName)) {
				customer = entry.getValue();
				break;
			}
		}
		return customer;
	}

	public String postCustomerDetails(Customer customer) {
		customerDetails.put(customer.getName(), customer);
		return "Successfully added new customer : " + customer.getName();
	}

	public String deleteCustomerDetails(String customerName) {
		for (Entry<String, Customer> entry : customerDetails.entrySet()) {
			if (entry.getKey().equalsIgnoreCase(customerName)) {
				customerDetails.remove(customerName);
				break;
			}
		}
		return "Customer " + customerName + " Deleted";
	}
}
