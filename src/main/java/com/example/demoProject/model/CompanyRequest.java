package com.example.demoProject.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="company")
public class CompanyRequest {
    @Id
    private int compId;

    @NotNull(message = "Company name should not be null")
    @NotBlank(message = "Company name should not be blank")
    private String compName;

    @NotNull(message = "Company operation should be present")
    @NotBlank(message = "Company name should be present")
    private String operation;
}
