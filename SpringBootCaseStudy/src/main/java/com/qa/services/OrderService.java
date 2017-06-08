package com.qa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.model.Orders;
import com.qa.repositories.OrderRepository;

@Service
public class OrderService {

	
	@Autowired
	private OrderRepository orderRepository;
	
	public Orders createOrder(Orders o){		
		return orderRepository.save(o);
	}
	
	public Iterable<Orders> getAllOrders(){
		
		return orderRepository.findAll();
	}
	
	public Iterable<Orders> getAllOrdersByCustomerId(String id){
		
		return orderRepository.getOrdersBycustomerId(id);
	}
	
	public Iterable<Orders> getAllOrdersByDate(String date){
		
		return orderRepository.getOrdersByDate(date);
	}
}
