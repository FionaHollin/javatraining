package com.qa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.model.Basket;
import com.qa.model.Book;
import com.qa.repositories.BasketRepository;

@Service
public class BasketService {

	@Autowired
	private BasketRepository basketRepository;

	public Basket createBasket(Basket b){
		
		return basketRepository.save(b);
	}
	
	
	public int addBookToBasket(int id, String bookId){
		return basketRepository.updateBasketWithBook(id, bookId);
	}
	
	public Basket findCustomerBasket(String customerId){
		
		return basketRepository.getBasketByCustomerId(customerId);
	}
	
	public Basket findBasketById(String bookId){
		
		return basketRepository.getBasketByCustomerId(bookId);
	}
}
