package com.rseat.vacancy_management.modules.company.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity(name = "jobs")
@Data
public class JobEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String description;
    private String level;
    private String benefits;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private CompanyEntity company;

    @CreationTimestamp
    private LocalDateTime createdAt;

}
