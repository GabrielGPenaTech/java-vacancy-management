package com.rseat.vacancy_management.modules.company.useCases;

import com.rseat.vacancy_management.modules.candidate.exceptions.UserFoundException;
import com.rseat.vacancy_management.modules.company.entities.CompanyEntity;
import com.rseat.vacancy_management.modules.company.repositories.CompanyRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateCompanyUseCase {

    private final CompanyRepository companyRepository;

    public CreateCompanyUseCase(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }


    public CompanyEntity execute(CompanyEntity company) {
        this.companyRepository.findByUsernameOrEmail(company.getUsername(), company.getEmail())
                .ifPresent(companyEntity -> {
                    throw new UserFoundException();
                });

        return this.companyRepository.save(company);
    }
}
