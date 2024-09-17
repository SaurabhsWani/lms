package com.saurbah.lms.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saurbah.lms.model.Borrowing;

public interface BorrowingRepository extends JpaRepository<Borrowing, Long> {

	List<Borrowing> findByReturnDateNull();

}
