package com.qa.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.qa.model.Basket;

public interface BasketRepository extends CrudRepository<Basket, Integer>{

	
	//Get all books by catagory
	@Query("SELECT a from Basket a where a.id =:id")
	public Basket getBasketById(@Param("id") int id);
	
	
	@Modifying
	@Transactional
	@Query("UPDATE Basket b set b.bookId = :bookId where b.id = :id")
	public int updateBasketWithBook(@Param("id")int id, @Param("bookId") String bookId);

	
	@Query("SELECT a from Basket a where a.customerId =:customerId")
	public Basket getBasketByCustomerId(@Param("customerId") String customerId);
	
	@Query("SELECT a from Basket a where a.bookId =:bookId")
	public Basket getBasketByBookId(@Param("bookId") String bookId);
}
