package com.keyin.member;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/members")
public class MemberController {

    private final MemberService service;

    public MemberController(MemberService service) {
        this.service = service;
    }

    @PostMapping
    public Member createMember(@RequestBody Member member) {
        return service.createMember(member);
    }

    @GetMapping
    public List<Member> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Member getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping("/search/by-name")
    public List<Member> searchByName(@RequestParam String name) {
        return service.searchByName(name);
    }

    @GetMapping("/search/by-membership-type")
    public List<Member> searchByMembershipType(@RequestParam MembershipType type) {
        return service.searchByMembershipType(type);
    }

    @GetMapping("/search/by-phone")
    public List<Member> searchByPhone(@RequestParam String phone) {
        return service.searchByPhone(phone);
    }

    @GetMapping("/search/by-tournament-start-date")
    public List<Member> searchByTournamentStartDate(
            @RequestParam
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date
    ) {
        return service.searchByTournamentStartDate(date);
    }
}
