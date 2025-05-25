package com.srinproject.srinlibrary.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.srinproject.srinlibrary.persistence.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
}

