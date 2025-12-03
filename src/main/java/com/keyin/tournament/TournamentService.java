package com.keyin.tournament;

import com.keyin.member.Member;
import com.keyin.member.MemberRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TournamentService {

    private final TournamentRepository tournamentRepository;
    private final MemberRepository memberRepository;

    public TournamentService(TournamentRepository tournamentRepository, MemberRepository memberRepository) {
        this.tournamentRepository = tournamentRepository;
        this.memberRepository = memberRepository;
    }


    public Tournament createTournament(Tournament tournament) {
        return tournamentRepository.save(tournament);
    }

    public List<Tournament> getAll() {
        return tournamentRepository.findAll();
    }

    public Tournament getById(Long id) {
        return tournamentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tournament not found with id: " + id));
    }


    public Tournament addMemberToTournament(Long tournamentId, Long memberId) {
        Tournament tournament = getById(tournamentId);
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new RuntimeException("Member not found with id: " + memberId));

        tournament.getParticipatingMembers().add(member);
        return tournamentRepository.save(tournament);
    }


    public List<Tournament> searchByStartDate(LocalDate date) {
        return tournamentRepository.findByStartDate(date);
    }

    public List<Tournament> searchByLocation(String location) {
        return tournamentRepository.findByLocationContainingIgnoreCase(location);
    }

    public List<Tournament> searchByEndDate(LocalDate date) {
        return tournamentRepository.findByEndDate(date);
    }
}
