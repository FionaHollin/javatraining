package com.qa.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.qa.model.Basket;
import com.qa.model.Book;
import com.qa.model.Customer;
import com.qa.services.BasketService;
import com.qa.services.BookService;
import com.qa.services.CustomerService;

@Controller
@Scope("session")
@SessionAttributes({"customerId"})
public class MyController {

	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private BasketService basketService;
	
	//should have some mapping methods
	
	@ModelAttribute("basket")
	public Basket defaultBasket(){
		
		return new Basket();
	}
	
	@RequestMapping("/")
	public String hello(){
		
		return "Welcome";
	}
	
	@RequestMapping("/browse")
	public ModelAndView search(){
		Iterable<Book> allBooks = bookService.getAllBooks();
		ModelAndView mv = new ModelAndView("Browse","allBooks", allBooks);
		return mv;
	}
	
	@RequestMapping("/basket")
	public @ResponseBody ModelAndView viewBasket(@RequestParam("id") int id, HttpSession session, @ModelAttribute Basket b){
		int custId = (int)session.getAttribute("customerId");
		String customerId = Integer.toString(custId);
		Basket basket = basketService.findCustomerBasket(customerId);
		int basketId = basket.getId();
		if(basketId != 0){
			String idString = Integer.toString(id);
			basketService.addBookToBasket(basket.getId(), idString);
			System.out.println("have you worked yet?  " + bookService.getAllBooksById(id));
			Basket currentBasket = basketService.findCustomerBasket(customerId);
			System.out.println("basket " + currentBasket);
			ModelAndView mvb= new ModelAndView("Basket","basket", currentBasket);
			mvb.addObject(customerService.findCustomerById(custId));
			mvb.addObject(bookService.getAllBooksById(Integer.parseInt(currentBasket.getBooks())));
			return mvb;
		}else{
			Basket newBasket=basketService.createBasket(b);
			String idString = Integer.toString(id);
			basketService.addBookToBasket(newBasket.getId(), idString);
			ModelAndView mvb= new ModelAndView("Basket","basket", basket);
			return mvb;		
		}
		
	}
	
	@RequestMapping("/book")
	public String viewMore(int id){
		bookService.getAllBooksById(id);
		return "Browse";
	}
	
	@RequestMapping("/enterABook")
	public String enterBookDetails(){
		return "AddBook";
	}
	
	@RequestMapping("/addBook")
	public String addBook(Book b){
		bookService.createBook(b);
		return "Welcome";
	}
	
	@RequestMapping("/login")
	public String viewLoginPage(){
		return "login";
	}
	
	@RequestMapping("/logout")
	public ModelAndView viewLogoutPage(HttpServletRequest request, @RequestParam("id") int id){
		Customer customer = customerService.findCustomerById(id);
		System.out.println(customer);
		request.setAttribute("customerId", 0);
		ModelAndView mv = new ModelAndView("logout","customer", customer);
		return mv;
	}
		
	@RequestMapping("/register")
	public String registrationProcess(Customer c,  HttpServletRequest request){
		request.getSession().setAttribute("customerId", 0);
		if(!c.getFirstName().equals("") && !c.getEmail().equals("") && !c.getPassword().equals("")){
			Customer customer = customerService.findCustomer(c.getEmail());
			if(customer == null){
				System.out.println("valid input");
				customerService.createCustomerRecord(c);
				request.getSession().setAttribute("customerId", 0);
				request.getSession().setAttribute("customerId", c.getId());
				return "profile";
			}else{
				return "failedRegistration";
			}
		}else{
			System.out.println("invalid input");
			return "login";
		}
	}
	
	@RequestMapping("/update")
	public String amendDetails(Customer c,  HttpServletRequest request){
		customerService.deleteCustomerRecord(c.getId());
		customerService.createCustomerRecord(c);
		return "profile";
	}
	
	
	@RequestMapping(value = "/searchByTitle", method= RequestMethod.GET)
	public ModelAndView searchByTitle(@RequestParam("title") String title, HttpServletRequest request){
		Iterable<Book> book = bookService.getAllBooksTitle(title);
		ModelAndView mv = new ModelAndView("Book","book", book);
		return mv;
	}
	
	@RequestMapping(value = "/more", method= RequestMethod.GET)
	public ModelAndView viewMoreByTitle(@RequestParam("title") String title, HttpServletRequest request){
		Iterable<Book> book = bookService.getAllBooksTitle(title);
		ModelAndView mv = new ModelAndView("Book","book", book);
		return mv;
	}
	
	@RequestMapping(value = "/edit", method=RequestMethod.GET)
	public ModelAndView editProfile(HttpServletRequest request, @RequestParam("id") int id){
		Customer customer = customerService.findCustomerById(id);
		ModelAndView mv = new ModelAndView("EditProfile","customer", customer);
		return mv;
	}
	
	@RequestMapping(value = "/profile", method=RequestMethod.GET)
	public ModelAndView findCustomerByEmail(@RequestParam("email") String email, @RequestParam("password") String password, HttpServletRequest request){
		Customer customer = customerService.findCustomer(email);
		if(customer != null){
		request.getSession().removeAttribute("customerId");
		System.out.println(customer);
		System.out.println(password);
		if(customer.getPassword().equals(password)){
			request.getSession().setAttribute("customerId", customer.getId());
			System.out.println("Am I fiona's" + request.getSession().getAttribute("customerId"));
			ModelAndView mv = new ModelAndView("profile","customer", customer);
			return mv;
		}else{
			ModelAndView mv2 = new ModelAndView("failedLogin","email", email);
			return mv2;
		}}else{
			ModelAndView mv3 = new ModelAndView("Welcome","email", email);
			return mv3;
		}
	}
}
