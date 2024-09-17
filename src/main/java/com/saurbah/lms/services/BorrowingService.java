package com.saurbah.lms.services;

import com.saurbah.lms.model.Borrowing;

public interface BorrowingService {

	Borrowing borrowBook(Long bookId, Long memberId);

	Borrowing returnBook(Long borrowingId);
}
