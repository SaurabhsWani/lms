package com.saurbah.lms.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saurbah.lms.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
