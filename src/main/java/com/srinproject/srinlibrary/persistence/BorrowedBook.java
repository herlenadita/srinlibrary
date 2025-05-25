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

    // Getters and Setters
}

