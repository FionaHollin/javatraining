package com.qa.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.qa.model.Orders;

public interface OrderRepository extends CrudRepository<Orders, Integer>{
	
	//Get all orders by customerId
	@Query("SELECT o from Orders o where o.customerId like %:customerId%")
	public Iterable<Orders>  getOrdersBycustomerId(@Param("customerId") String customerId);
	
	//Get all orders by date
	@Query("SELECT o from Orders o where o.date like %:date%")
	public Iterable<Orders>  getOrdersByDate(@Param("date") String date);

}
