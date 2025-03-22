package com.rseat.vacancy_management.modules.candidate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.util.UUID;

@Data
public class CandidateEntity {

    private UUID  id;

    @Pattern(regexp = "\\S+", message = "The field [name] should not be contain spaces")
    private String name;

    @Email(message = "Field [email] should be valid!")
    private String email;
    private String username;

    @Length(min = 10, max = 100, message = "Password should be contain 10 - 100 characters")
    private String password;
    private String description;
    private String curriculum;


}
