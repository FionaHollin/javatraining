package com.qa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.model.Book;
import com.qa.repositories.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;

	public Iterable<Book> getAllBooks(){
		
		return bookRepository.findAll();
	}
	
	public Book createBook(Book b){
		
		return bookRepository.save(b);
	}
	
	public Iterable<Book> getAllBooksTitle(String title){
		
		return bookRepository.getBooksByTitle(title);
	}
	
	public Iterable<Book> getAllBooksByAuthor(String author){
		
		return bookRepository.getBooksByAuthor(author);
	}
	
	public Book getAllBooksById(int id){
		
		return bookRepository.getBookById(id);
		}
	
	public Iterable<Book> getAllBooksByISBN(String ISBN){
		
		return bookRepository.getBooksByISBN(ISBN);
	}
	
	public Iterable<Book> getAllBooksByCatagory(String catagory){
		
		return bookRepository.getBooksByCatagory(catagory);
	}

	public int updateStockNumberById(int id, int stockNumber){

		return bookRepository.updateBookStock(id, stockNumber);
	}
}
