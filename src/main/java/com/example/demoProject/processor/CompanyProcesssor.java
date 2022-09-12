package com.example.demoProject.processor;

import com.example.demoProject.model.CompanyRequest;
import com.example.demoProject.repository.CompanyRepository;
import com.example.demoProject.services.CompanyServices;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CompanyProcesssor implements Processor {
    @Autowired
    private CompanyServices companyServices;

    @Override
    public void process(Exchange exchange) throws Exception {
        String payload = exchange.getIn().getBody(String.class);
        if (payload.startsWith("{") || payload.startsWith("[")) {
        ObjectMapper mapper = new ObjectMapper();
        CompanyRequest compObj= mapper.readValue(payload,CompanyRequest.class);
        if (compObj.getOperation().equalsIgnoreCase("create")) {
            companyServices.newCompanydata(compObj);
        }
        }
    }

}






