package com.qa.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.qa.model.Book;

public interface BookRepository extends CrudRepository<Book, Integer>{

	@Modifying
	@Transactional
	@Query("UPDATE Book b set b.stock_number = :stockNumber where b.id = :id")
	public int updateBookStock(@Param("id")int id, @Param("stockNumber") int stock_number);
	
	//Get all books by title
	@Query("SELECT b from Book b where b.title like %:title%")
	public Iterable<Book> getBooksByTitle(@Param("title") String title);
		
	@Query("SELECT b from Book b where b.id =:id")
	public Book getBookById(@Param("id") int id);
	
	//Get all books by author
	@Query("SELECT b from Book b where b.author like %:author%")
	public Iterable<Book>  getBooksByAuthor(@Param("author") String author);
	
	//Get all books by ISBN
	@Query("SELECT b from Book b where b.ISBN like :ISBN")
	public Iterable<Book>  getBooksByISBN(@Param("ISBN") String ISBN);
	
	//Get all books by catagory
	@Query("SELECT b from Book b where b.catagory like :catagory")
	public Iterable<Book>  getBooksByCatagory(@Param("catagory") String catagory);
}
