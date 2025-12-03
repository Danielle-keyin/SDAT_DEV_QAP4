package com.keyin.member;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {

    List<Member> findByNameContainingIgnoreCase(String name);

    List<Member> findByMembershipType(MembershipType membershipType);

    List<Member> findByPhoneNumberContaining(String phoneNumber);

    @Query("""
           SELECT DISTINCT m
           FROM Member m
           JOIN m.tournaments t
           WHERE t.startDate = :startDate
           """)
    List<Member> findByTournamentStartDate(LocalDate startDate);
}
