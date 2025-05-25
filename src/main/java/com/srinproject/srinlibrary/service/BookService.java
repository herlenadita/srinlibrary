package com.srinproject.srinlibrary.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.srinproject.srinlibrary.persistence.Author;
import com.srinproject.srinlibrary.persistence.Book;
import com.srinproject.srinlibrary.repository.AuthorRepository;
import com.srinproject.srinlibrary.repository.BookRepository;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
    
    public Book addBook(Book book) {
        // Check if the author exists
        if (book.getAuthor() != null && book.getAuthor().getId() != null) {
            Author author = authorRepository.findById(book.getAuthor().getId())
                    .orElseThrow(() -> new RuntimeException("Author not found with id " + book.getAuthor().getId()));
            book.setAuthor(author);
        }
        return bookRepository.save(book);
    }

    public Book updateBook(Long id, Book bookDetails) {
        Book book = bookRepository.findById(id).orElseThrow();
        book.setTitle(bookDetails.getTitle());
        book.setCategory(bookDetails.getCategory());
        book.setPublishingYear(bookDetails.getPublishingYear());
        book.setAuthor(bookDetails.getAuthor());
        return bookRepository.save(book);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}

