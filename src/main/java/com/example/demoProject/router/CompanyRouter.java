package com.example.demoProject.router;

import com.example.demoProject.processor.CompanyProcesssor;
import com.example.demoProject.processor.EmployeeProcessor;
import com.example.demoProject.services.EmployeeServices;
import org.apache.camel.Predicate;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CompanyRouter extends RouteBuilder {

    @Autowired
    private CompanyProcesssor companyProcesssor;


    @Override
    public void configure() throws Exception {
        from("activemq:CompanyQueue")
                .process(companyProcesssor)
                .end();

    }
}
