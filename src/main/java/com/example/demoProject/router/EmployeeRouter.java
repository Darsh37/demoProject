package com.example.demoProject.router;

import com.example.demoProject.processor.EmployeeProcessor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeRouter extends RouteBuilder {
    @Autowired
    private EmployeeProcessor employeeProcessor;

    @Override
    public void configure() throws Exception {
        from("activemq:EmployeeQueue")
                .process(employeeProcessor)
                .end();

    }
}
