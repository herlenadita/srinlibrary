package com.srinproject.srinlibrary.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.srinproject.srinlibrary.persistence.Author;
import com.srinproject.srinlibrary.persistence.Book;
import com.srinproject.srinlibrary.persistence.BorrowedBook;
import com.srinproject.srinlibrary.persistence.Member;
import com.srinproject.srinlibrary.repository.BookRepository;
import com.srinproject.srinlibrary.repository.BorrowedBookRepository;
import com.srinproject.srinlibrary.repository.MemberRepository;

@Service
public class BorrowedBookService {
    @Autowired
    private BorrowedBookRepository borrowedBookRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private MemberRepository memberRepository;

    public List<BorrowedBook> getAllBorrowedBooks() {
        return borrowedBookRepository.findAll();
    }

    public BorrowedBook addBorrowedBook(BorrowedBook borrowedBook) {
        // Check if the book exists
        if (borrowedBook.getBook() != null && borrowedBook.getBook().getId() != null) {
            Book book = bookRepository.findById(borrowedBook.getBook().getId())
                    .orElseThrow(() -> new RuntimeException("Book not found with id " + borrowedBook.getBook().getId()));
            borrowedBook.setBook(book);
        }

        if (borrowedBook.getMember() != null && borrowedBook.getMember().getId() != null) {
            Member member = memberRepository.findById(borrowedBook.getMember().getId())
                    .orElseThrow(() -> new RuntimeException("Member not found with id " + borrowedBook.getMember().getId()));
            borrowedBook.setMember(member);
        }

        return borrowedBookRepository.save(borrowedBook);
    }

    public BorrowedBook updateBorrowedBook(Long id, BorrowedBook borrowedBookDetail) {
        BorrowedBook borrowedBook = borrowedBookRepository.findById(id).orElseThrow();
        borrowedBook.setBorrowDate(borrowedBookDetail.getBorrowDate());
        borrowedBook.setReturnDate(borrowedBookDetail.getReturnDate());
        borrowedBook.setBook(borrowedBookDetail.getBook());
        borrowedBook.setMember(borrowedBookDetail.getMember());
        return borrowedBookRepository.save(borrowedBook);
    }
    
    public void deleteBorrowedBook(Long id) {
        borrowedBookRepository.deleteById(id);
    }

    public List<BorrowedBook> findBorrowedBooks(String bookTitle, String memberName, Date borrowDate) {
        return borrowedBookRepository.findByFilters(
                (bookTitle != null && !bookTitle.isEmpty()) ? bookTitle.toLowerCase() : null,
                (memberName != null && !memberName.isEmpty()) ? memberName.toLowerCase() : null,
                borrowDate
        );
    }
}
