package com.srinproject.srinlibrary.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.srinproject.srinlibrary.persistence.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}

