package com.srinproject.srinlibrary.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.srinproject.srinlibrary.persistence.Member;
import com.srinproject.srinlibrary.repository.MemberRepository;

@Service
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    public Member getMemberById(Long id) {
        return memberRepository.findById(id).orElseThrow(() -> new RuntimeException("Author not found with id " + id));
    }

    public Member addMember(Member member) {
        return memberRepository.save(member);
    }

    public Member updatMember(Long id, Member memberDetails) {
        Member member = getMemberById(id);
        member.setName(memberDetails.getName());
        member.setEmail(memberDetails.getEmail());
        member.setPhone(memberDetails.getPhone());
        return memberRepository.save(member);
    }

    public void deleteMember(Long id) {
        memberRepository.deleteById(id);
    }


}
