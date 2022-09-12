package com.example.demoProject.services;

import com.example.demoProject.entity.Company;
import com.example.demoProject.exception.ResourceNotFoundException;
import com.example.demoProject.model.CompanyRequest;
import com.example.demoProject.repository.CompanyRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServices {
    static Logger logger= LogManager.getLogger(EmployeeServices.class);

    @Autowired
    private CompanyRepository companyRepository;

    public String getAllCompanyData() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Company> compData = companyRepository.findAll();
        String compRespString = objectMapper.writeValueAsString(compData);
        return compRespString;
    }
//        public Boolean saveCompanyData(CompanyRequest companyRequest) {
//            try {
//                Company comp =new Company();
//                comp.setCompName(companyRequest.getCompName());
//                return true;
//            } catch (Exception e) {
//                throw new RuntimeException(e);
//            }
//        }
        public Boolean newCompanydata(CompanyRequest companyRequest) {
        try {
            Company comp = new Company();
            if(companyRequest.getCompName().isEmpty() || companyRequest.getCompName().length()==0){
                throw new ResourceNotFoundException("Name should not be null or Empty");
            }
            else {
                comp.setCompName(companyRequest.getCompName());
                Company savedCompany = companyRepository.save(comp);
                logger.info("Data of Company is created");
            }
            return true;
        }
        catch (Exception e) {
            logger.info("Error");
            return false;
        }
    }
}
