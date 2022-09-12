package com.example.demoProject.controller;

import com.example.demoProject.exception.ResourceNotFoundException;
import com.example.demoProject.services.CompanyServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    CompanyServices companyServices;

    @GetMapping("/all")
    public ResponseEntity<String> getAllcompData(){
        ResponseEntity<String> response;
        try {
            String compsResponseString =companyServices.getAllCompanyData();
            response =ResponseEntity.status(HttpStatus.OK).body(compsResponseString);
            return response;
        } catch (ResourceNotFoundException r) {
            response = ResponseEntity
                    .status(HttpStatus.OK)
                    .body("Entity not found");
            return response;
        } catch (Exception e) {
            response = ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Exception Occurred");
            return response;
        }
    }
}
