package com.rseat.vacancy_management.modules.company.controllers;

import com.rseat.vacancy_management.modules.company.entities.JobEntity;
import com.rseat.vacancy_management.modules.company.useCases.CreateJobUseCase;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jobs")
public class JobController {

    private final CreateJobUseCase createJobUseCase;


    public JobController(CreateJobUseCase createJobUseCase) {
        this.createJobUseCase = createJobUseCase;
    }

    @PostMapping
    public ResponseEntity<Object> create(@Valid @RequestBody JobEntity job) {
        try {
            var result = this.createJobUseCase.execute(job);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
