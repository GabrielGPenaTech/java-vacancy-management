package com.rseat.vacancy_management.modules.company.repositories;

import com.rseat.vacancy_management.modules.company.entities.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CompanyRepository  extends JpaRepository<CompanyEntity, UUID> {

    Optional<CompanyEntity> findByUsernameOrEmail(String username, String email);
}
