package com.srinproject.srinlibrary.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.srinproject.srinlibrary.persistence.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}

