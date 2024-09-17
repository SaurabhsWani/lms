package com.saurbah.lms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.saurbah.lms.repo.BookRepository;
import com.saurbah.lms.repo.BorrowingRepository;
import com.saurbah.lms.repo.MemberRepository;
import com.saurbah.lms.services.BorrowingService;

@Controller
public class BorrowingController {

	@Autowired
	BookRepository bookRepository;

	@Autowired
	MemberRepository memberRepository;

	@Autowired
	BorrowingRepository borrowingRepository;

	@Autowired
	BorrowingService borrowingService;

	@GetMapping("/borrow")
	public String showBorrowForm(Model model) {
		model.addAttribute("members", memberRepository.findAll());
		model.addAttribute("books", bookRepository.findAll());
		return "borrow_book";
	}

	@PostMapping("/borrow")
	public String borrowBook(@RequestParam Long memberId, @RequestParam Long bookId, Model model) {
		borrowingService.borrowBook(bookId, memberId);
		model.addAttribute("message", "Book borrowed successfully!");
		return "borrow_success";
	}

	@GetMapping("/return")
	public String showReturnBookForm(Model model) {
		model.addAttribute("borrowers", borrowingRepository.findByReturnDateNull());
		return "return_book";
	}

	@PostMapping("/return")
	public String returnBook(Model model, @RequestParam Long borrowingId) {
		borrowingService.returnBook(borrowingId);
		model.addAttribute("message", "Book return successfully!");
		return "return_success";
	}
}
