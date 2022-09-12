package com.example.demoProject.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ValidationBean extends RuntimeException{
    private String errorCode;
    private String errorMessage;
    private String type;
}
