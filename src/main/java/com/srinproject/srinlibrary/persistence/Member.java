package com.srinproject.srinlibrary.persistence;

import javax.persistence.*;
import java.util.List;

@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phone;

    @OneToMany(mappedBy = "member")
    private List<BorrowedBook> borrowedBooks;

    // Getters and Setters
}

