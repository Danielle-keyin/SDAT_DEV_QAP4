package com.keyin.member;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class MemberService {

    private final MemberRepository repository;

    public MemberService(MemberRepository repository) {
        this.repository = repository;
    }

    public Member createMember(Member member) {
        return repository.save(member);
    }

    public List<Member> getAll() {
        return repository.findAll();
    }

    public Member getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Member not found"));
    }

    public List<Member> searchByName(String name) {
        return repository.findByNameContainingIgnoreCase(name);
    }

    public List<Member> searchByMembershipType(MembershipType type) {
        return repository.findByMembershipType(type);
    }

    public List<Member> searchByPhone(String phone) {
        return repository.findByPhoneNumberContaining(phone);
    }

    public List<Member> searchByTournamentStartDate(LocalDate date) {
        return repository.findByTournamentStartDate(date);
    }
}
