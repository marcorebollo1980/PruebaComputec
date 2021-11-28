package com.desarrolloPruebaComputec.co.prueba.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.desarrolloPruebaComputec.co.prueba.model.Book;

public interface BookRepository extends MongoRepository<Book, Integer>{

}
