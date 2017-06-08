package com.qa.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.qa.model.Book;
import com.qa.model.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer>{

	
	//JPA query language used in query annotation, JPA uses class name as table name and field names, c= table alias 
	//:email=placeholder whatever is in @Param annotation, must match the placeholders. 
	
	@Modifying
	@Transactional
	@Query("UPDATE Customer c set c.firstName = :firstName, c.lastName = :lastName where c.id = :id")
	public int updateCustomerName(@Param("id")int id, @Param("firstName") String firstName, @Param("lastName") String lastName);
	
	@Modifying
	@Transactional
	@Query("UPDATE Customer c set c = :customer where c.id = :id")
	public int updateCustomerRecordById(@Param("id")int id, @Param("customer") Customer customer);
	
	@Modifying
	@Transactional
	@Query("UPDATE Customer c set c.password = :password where c.id = :id")
	public int updateCustomerPassword(@Param("id")int id, @Param("password") String password);
	
	@Modifying
	@Transactional
	@Query("UPDATE Customer c set c.cardNumber = :cardNumber, c.cardExpiryDate = :cardExpiryDate, c.securityCode = :securityCode where c.id = :id")
	public int updateCustomerCard(@Param("id")int id, @Param("cardNumber") String cardNumber, @Param("cardExpiryDate") String cardExpiryDate, @Param("securityCode") String securityCode);

	@Query("SELECT c from Customer c where c.email =:email")
	public Customer getCustomerByEmail(@Param("email") String email);
		
	
	@Query("SELECT c from Customer c where c.id =:id")
	public Customer getCustomerById(@Param("id") int id);
}
