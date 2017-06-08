package com.qa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.model.Customer;
import com.qa.repositories.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	public Customer createCustomerRecord(Customer c){
		
		return customerRepository.save(c);
	}
	
	public void deleteCustomerRecord(int id){
		
		customerRepository.delete(id);;
	}
	
	public int updateCustomerNameById(int id, String firstName, String lastName){

		return customerRepository.updateCustomerName(id, firstName, lastName);
	}
	
	public int updateCustomerRecord(int id, Customer c){
		
		return customerRepository.updateCustomerRecordById(id, c);
	}
	
	public int updateCustomerPasswordById(int id, String password){
		
		return customerRepository.updateCustomerPassword(id, password);
	}
	
	public int updateCustomerCardById(int id, String cardNumber, String cardExpiryDate, String securityCode){
		
		return customerRepository.updateCustomerCard(id, cardNumber, cardExpiryDate, securityCode);
	}
	
	public Customer findCustomer(String email){
		
		return customerRepository.getCustomerByEmail(email);
		
	}
	
	public Customer findCustomerById(int id){
		
		return customerRepository.getCustomerById(id);
		
	}
	
}
