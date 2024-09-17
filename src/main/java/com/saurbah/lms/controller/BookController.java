package com.saurbah.lms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.saurbah.lms.model.Book;
import com.saurbah.lms.repo.BookRepository;

@Controller
public class BookController {

	@Autowired
	private BookRepository repository;

	@GetMapping("/")
	public String listBook(Model model) {
		model.addAttribute("books", repository.findAll());
		return "books";
	}

	@GetMapping("/book/new")
	public String showCreateForm(Model model) {
		Book book = new Book();
		model.addAttribute("book", book);
		return "create_book";
	}

	@PostMapping("/books")
	public String saveBook(@ModelAttribute Book book) {
		repository.save(book);
		return "redirect:/";
	}

	@GetMapping("/books/delete/{id}")
	public String deletBook(@PathVariable("id") Long bookId, Model model) {
		repository.deleteById(bookId);
		model.addAttribute("message", "Book Deleted successfully!");
		return "redirect:/";
	}

	@GetMapping("/books/{id}")
	public String getBookEditForm(@PathVariable("id") Long bookId, Model model) {
		Book book = repository.findById(bookId).get();
		model.addAttribute("book", book);
		return "update_book";
	}
}
