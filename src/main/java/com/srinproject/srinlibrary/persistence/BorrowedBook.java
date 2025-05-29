package com.srinproject.srinlibrary.persistence;

import javax.persistence.*;
import java.util.Date;

@Entity
public class BorrowedBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    private Date borrowDate;
    private Date returnDate;

    public Long getId() {
        return id;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book)
    {
        this.book = book;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member)
    {
        this.member = member;
    }
    // Getters and Setters
}

