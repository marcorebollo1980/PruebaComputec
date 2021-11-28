package com.desarrolloPruebaComputec.co.prueba.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@PutMapping("/updateBook/{id}")
	public ResponseEntity<Book> updateTutorial(@PathVariable("id") int id, @RequestBody Book book) {
	  Optional<Book> bookData = bookRepository.findById(id);

	  if (bookRepository != null) {
	    Book b = bookData.get();
	    b.setBookName(book.getBookName());
	    b.setAuthorName(book.getAuthorName());
	    return new ResponseEntity<>(bookRepository.save(b), HttpStatus.OK);
	  } else {
	    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	  }
	}
	
	@DeleteMapping("/deleteBook/{id}")
	public ResponseEntity<HttpStatus> deleteBook(@PathVariable("id") int id) {
	  try {
		  bookRepository.deleteById(id);
	    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	  } catch (Exception e) {
	    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	  }
	}
	
	
	
}
