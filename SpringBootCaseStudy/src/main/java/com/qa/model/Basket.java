package com.qa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Basket {

	
	@Id
	@GeneratedValue
	private int id;
	
	private String customerId;
	
	@Column(name = "book_id", nullable = true, columnDefinition = "int default 0")
	private String bookId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCustomer() {
		return customerId;
	}

	public void setCustomer(String  customer) {
		this.customerId = customer;
	}

	public String getBooks() {
		return bookId;
	}

	public void setBooks(String book) {
		this.bookId = book;
	}

	@Override
	public String toString() {
		return "Basket [id=" + id + ", customer=" + customerId + ", books=" + bookId + "]";
	}
	
	
	
}
