package com.codingdojo.nrampton.books.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.nrampton.books.models.Book;

@Service
public class BookService {
	private List<Book> books = new ArrayList<Book> (Arrays.asList(
			new Book("Leviathan Wakes", "Space Opera", "English", 400),
			new Book("The Brothers K", "Brothers in mid-20th century America", "English", 500),
			new Book("The Brothers Karamazov", "Brothers in late-19th-century Russia", "Russian", 400),
			new Book("Hitsuji wo Meguru Bouken", "A lonely guy gets even lonelier", "Japanese", 250),
			new Book("How Green Was My Valley", "Welsh coal miners and their woes", "English", 350)
		));
	
	public List<Book> getAllBooks() {
		return books;
	}
	
	public Book findBookByIndex(int index) {
		if (index < books.size()) {
			return books.get(index);
		} else {
			return null;
		}
	}
	
	public void addBook(Book book) {
		books.add(book);
	}
	
	public void updateBook(int id, Book book) {
		if (id < books.size()) {
			books.set(id, book);
		}
	}
	
	public void destroyBook(int id) {
		if (id < books.size()) {
			books.remove(id);
		}
	}
}
