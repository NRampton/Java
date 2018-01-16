package com.codingdojo.nrampton.books.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.nrampton.books.models.Book;
import com.codingdojo.nrampton.books.repositories.BookRepository;

@Service
public class BookService {
	private BookRepository bookRepository;
	
	//constructor for dependency injection
	public BookService(BookRepository bookRepo) {
		this.bookRepository = bookRepo;
	}
	
	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}
	
	public Book findBookById(Long id) {
		return bookRepository.findOne(id);
	}
	
	public void addBook(Book book) {
		bookRepository.save(book);
	}
	
	public void updateBook(Book book) {
		bookRepository.save(book);
	}
	
	public void destroyBook(Long id) {
		bookRepository.delete(id);
	}
}
