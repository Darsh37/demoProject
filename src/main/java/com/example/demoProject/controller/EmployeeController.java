package com.example.demoProject.controller;

import com.example.demoProject.exception.ResourceNotFoundException;
import com.example.demoProject.services.EmployeeServices;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Configuration
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeServices employeeServices;

    @GetMapping("/all")
    public ResponseEntity<String> getData() throws JsonProcessingException {
        ResponseEntity<String> response1;
        try {
            String empsResponseString = employeeServices.getEmployeeData();
            response1 = ResponseEntity
                    .status(HttpStatus.OK).body(empsResponseString);
            return response1;
        } catch (ResourceNotFoundException r) {
            response1 = ResponseEntity.status(HttpStatus.OK).body("Not found");
            return response1;
        } catch (Exception e) {
            response1 = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Exception Occurred");
            return response1;
        }
    }

}
