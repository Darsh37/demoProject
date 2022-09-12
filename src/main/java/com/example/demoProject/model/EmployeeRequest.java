package com.example.demoProject.model;
import lombok.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeRequest {

    private  Integer id;

    @NotNull(message = "name should not be null")
    @NotBlank(message = "name should not be blank")
    private  String name;

    private int compId;

    @NotNull(message ="name should not be null")
    @NotBlank(message = "name should not be blank")
    private String operation;


}
