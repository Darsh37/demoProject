package com.example.demoProject.processor;

import com.example.demoProject.model.EmployeeRequest;
import com.example.demoProject.services.EmployeeServices;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;


@Component
public class EmployeeProcessor implements Processor {

    @Autowired
    private EmployeeServices employeeServices;


    @Override
    public void process(@Validated Exchange exchange) throws Exception {
        String payload = exchange.getIn().getBody(String.class);
        if (payload.startsWith("{") || payload.startsWith("[")) {
            ObjectMapper mapper = new ObjectMapper();
            EmployeeRequest empObj = mapper.readValue(payload, EmployeeRequest.class);
            if (empObj.getOperation().equalsIgnoreCase("create")) {
                employeeServices.newEmployeedata(empObj);
            }
            else if (empObj.getOperation().equalsIgnoreCase("update"))
            {
                employeeServices.updatedEmployee(empObj);
            }
           else if (empObj.getOperation().equalsIgnoreCase("delete"))
                employeeServices.deleteEmployeeData(empObj.getId());
//
//        }
        }
    }
}
