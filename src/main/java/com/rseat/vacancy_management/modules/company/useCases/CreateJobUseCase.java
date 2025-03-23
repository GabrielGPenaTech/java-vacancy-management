package com.rseat.vacancy_management.modules.company.useCases;

import com.rseat.vacancy_management.modules.company.entities.JobEntity;
import com.rseat.vacancy_management.modules.company.repositories.JobRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateJobUseCase {

    private final JobRepository jobRepository;

    public CreateJobUseCase(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    public JobEntity execute(JobEntity job) {
        return this.jobRepository.save(job);
    }
}
