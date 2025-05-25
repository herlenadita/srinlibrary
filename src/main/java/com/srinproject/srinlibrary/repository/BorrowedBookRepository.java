package com.srinproject.srinlibrary.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.srinproject.srinlibrary.persistence.BorrowedBook;

public interface BorrowedBookRepository extends JpaRepository<BorrowedBook, Long> {
    List<BorrowedBook> findByBookTitleContainingOrMemberNameContainingOrBorrowDate(Date borrowDate, String bookTitle, String memberName);
}

