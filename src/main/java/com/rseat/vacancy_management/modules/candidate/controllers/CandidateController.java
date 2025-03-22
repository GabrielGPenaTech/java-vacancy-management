package com.rseat.vacancy_management.modules.candidate.controllers;

import com.rseat.vacancy_management.modules.candidate.CandidateEntity;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/candidate")
public class CandidateController {


    @PostMapping
    public void create(@Valid @RequestBody CandidateEntity candidate) {
        System.out.println("Candidate created");
        System.out.println(candidate);
    }
}
