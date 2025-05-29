package com.srinproject.srinlibrary.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.srinproject.srinlibrary.persistence.BorrowedBook;

public interface BorrowedBookRepository extends JpaRepository<BorrowedBook, Long> {
    @Query("SELECT bb FROM BorrowedBook bb " +
           "JOIN bb.book b " +
           "JOIN bb.member m " +
           "WHERE (:bookTitle IS NULL OR LOWER(b.title) LIKE LOWER(CONCAT('%', :bookTitle, '%'))) " +
           "AND (:memberName IS NULL OR LOWER(m.name) LIKE LOWER(CONCAT('%', :memberName, '%'))) " +
           "AND (:borrowDate IS NULL OR bb.borrowDate = :borrowDate)")
    List<BorrowedBook> findByFilters(
            @Param("bookTitle") String bookTitle,
            @Param("memberName") String memberName,
            @Param("borrowDate") Date borrowDate);
}

