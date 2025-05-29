package com.srinproject.srinlibrary.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.srinproject.srinlibrary.persistence.BorrowedBook;
import com.srinproject.srinlibrary.service.BorrowedBookService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/borrowedBooks")
public class BorrowedBookController {
    @Autowired
    private BorrowedBookService borrowedBookService;

    // @GetMapping
    // public List<BorrowedBook> getAllBorrowedBooks() {
    //     return borrowedBookService.getAllBorrowedBooks();
    // }

    @GetMapping
    public List<BorrowedBook> getAllBorrowedBooks(
        @RequestParam(required = false) String bookTitle,
        @RequestParam(required = false) String memberName,
        @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date borrowDate
    ) {
        List<BorrowedBook> result = borrowedBookService.findBorrowedBooks(bookTitle, memberName, borrowDate);
        return result;
    }

    @PostMapping
    public BorrowedBook addborrowedBook(@RequestBody BorrowedBook borrowedBook) {
        return borrowedBookService.addBorrowedBook(borrowedBook);
    }

    @PutMapping("/{id}")
    public BorrowedBook updateborrowedBook(@PathVariable Long id, @RequestBody BorrowedBook borrowedBook) {
        return borrowedBookService.updateBorrowedBook(id, borrowedBook);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        borrowedBookService.deleteBorrowedBook(id);
    }
    
}
