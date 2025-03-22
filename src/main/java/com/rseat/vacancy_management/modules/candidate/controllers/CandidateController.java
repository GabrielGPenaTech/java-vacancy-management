package com.rseat.vacancy_management.modules.candidate.controllers;

import com.rseat.vacancy_management.modules.candidate.CandidateEntity;
import com.rseat.vacancy_management.modules.candidate.useCases.CreateCandidateUseCase;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

    private final CreateCandidateUseCase create;

    public CandidateController(CreateCandidateUseCase create) {
        this.create = create;
    }

    @PostMapping
    public ResponseEntity<Object> create(@Valid @RequestBody CandidateEntity candidate) {
       try {
           var result = this.create.execute(candidate);
           return ResponseEntity.ok().body(result);
       } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
       }
    }
}
