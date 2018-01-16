package com.codingdojo.nrampton.books.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.nrampton.books.models.Book;
import com.codingdojo.nrampton.books.services.BookService;

@Controller
public class BookController {
	
	private final BookService bs;
	public BookController(BookService bs) {
		this.bs = bs;
	}
	@RequestMapping("/books")
	public String showBooks(Model model) {
		List<Book> books = bs.getAllBooks();
		model.addAttribute("books", books);
		return "books";
	}
	
	@RequestMapping("/books/{index}")
	public String findBookByIndex(Model model, @PathVariable("index") Long index) {
		Book book = bs.findBookById(index);
		model.addAttribute("book", book);
		return "showBook";
	}
	
	@RequestMapping("/books/new")
	public String newBook(@ModelAttribute("book") Book book) {
		return "newBook";
	}
	
	@PostMapping("/books/new")
	public String createBook(@Valid @ModelAttribute("book") Book book, BindingResult result) {
		if (result.hasErrors()) {
			return "newBook";
		} else {
			bs.addBook(book);
			return "redirect:/books";
		}
	}
	
	@PostMapping("books/edit/{id}")
	public String updateBook(@PathVariable("id") Long id, @Valid @ModelAttribute("book") Book book, BindingResult result) {
		if (result.hasErrors()) {
			return "editBook";
		} else {
			bs.updateBook(book);
			return "redirect:/books";
		}
	}
	
	@RequestMapping("/books/edit/{id}")
	public String editBook(@PathVariable("id") Long id, Model model) {
		Book book = bs.findBookById(id);
		if (book != null) {
			model.addAttribute("book", book);
			return "editBook";
		} else {
			return "redirect:/books";
		}
	}
	
	@RequestMapping("/books/delete/{id}")
	public String destroyBook(@PathVariable("id") Long id) {
		bs.destroyBook(id);
		return "redirect:/books";
	}

}
