package com.saurbah.lms.services;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saurbah.lms.model.Borrowing;
import com.saurbah.lms.repo.BookRepository;
import com.saurbah.lms.repo.BorrowingRepository;
import com.saurbah.lms.repo.MemberRepository;

@Service
public class BorrowingServiceImpl implements BorrowingService {

	@Autowired
	BookRepository bookRepository;

	@Autowired
	MemberRepository memberRepository;

	@Autowired
	BorrowingRepository borrowingRepository;

	@Override
	public Borrowing borrowBook(Long bookId, Long memberId) {
		Borrowing borrowing = new Borrowing();
		borrowing.setBook(bookRepository.findById(bookId).get());
		borrowing.setMember(memberRepository.findById(memberId).get());
		borrowing.setBorrowingDate(new Date());
		return borrowingRepository.save(borrowing);
	}

	@Override
	public Borrowing returnBook(Long borrowingId) {
		Optional<Borrowing> borrowingObje = borrowingRepository.findById(borrowingId);
		Borrowing borrowing = borrowingObje.get();
		borrowing.setReturnDate(new Date());
		return borrowingRepository.save(borrowing);
	}

}
