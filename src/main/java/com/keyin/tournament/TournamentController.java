package com.keyin.tournament;

import com.keyin.member.Member;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/tournaments")
public class TournamentController {

    private final TournamentService service;

    public TournamentController(TournamentService service) {
        this.service = service;
    }


    @PostMapping
    public Tournament createTournament(@RequestBody Tournament tournament) {
        return service.createTournament(tournament);
    }

    @GetMapping
    public List<Tournament> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Tournament getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping("/{tournamentId}/members/{memberId}")
    public Tournament addMemberToTournament(@PathVariable Long tournamentId,
                                            @PathVariable Long memberId) {
        return service.addMemberToTournament(tournamentId, memberId);
    }

    @GetMapping("/{id}/members")
    public List<Member> getMembersForTournament(@PathVariable Long id) {
        // re-use service.getById so we throw a clear error if not found
        Tournament t = service.getById(id);
        return List.copyOf(t.getParticipatingMembers());
    }

    @GetMapping("/search/by-start-date")
    public List<Tournament> searchByStartDate(
            @RequestParam
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date
    ) {
        return service.searchByStartDate(date);
    }

    @GetMapping("/search/by-end-date")
    public List<Tournament> searchByEndDate(
            @RequestParam
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date
    ) {
        return service.searchByEndDate(date);
    }

    @GetMapping("/search/by-location")
    public List<Tournament> searchByLocation(@RequestParam String location) {
        return service.searchByLocation(location);
    }
}
