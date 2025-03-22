package com.rseat.vacancy_management.modules.candidate.useCases;

import com.rseat.vacancy_management.modules.candidate.CandidateEntity;
import com.rseat.vacancy_management.modules.candidate.CandidateRepository;
import com.rseat.vacancy_management.modules.candidate.exceptions.UserFoundException;
import org.springframework.stereotype.Service;

@Service
public class CreateCandidateUseCase {

    private final CandidateRepository candidateRepository;

    public CreateCandidateUseCase(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }

    public CandidateEntity execute(CandidateEntity candidate) {
        this.candidateRepository.findByUsernameOrEmail(candidate.getUsername(), candidate.getEmail())
                .ifPresent(candidateEntity -> {
                    throw new UserFoundException();
                });

        return this.candidateRepository.save(candidate);
    }
}
