package com.desarrolloPruebaComputec.co.prueba.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.desarrolloPruebaComputec.co.prueba.model.Book;
import com.desarrolloPruebaComputec.co.prueba.repository.BookRepository;

@RestController
public class BookController {

	@Autowired
	private BookRepository bookRepository;
	
	@PostMapping("/addBook")
	public String saveBook(@RequestBody Book book) {
		bookRepository.save(book);
		return "Libro agregado con id="+ book.getId();
	} 
	
	@GetMapping("/findAllBooks")
	public List<Book> getBooks(){
	   return bookRepository.findAll();	
	}
	
	
	@GetMapping("/findOneBook/{id}")
	public Optional<Book> getBook(@PathVariable int id){
	   return bookRepository.findById(id);	
	}
	
	
	
	
}
