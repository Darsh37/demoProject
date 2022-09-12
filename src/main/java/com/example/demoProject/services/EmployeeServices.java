package com.example.demoProject.services;
import com.example.demoProject.entity.Employee;
import com.example.demoProject.exception.ResourceNotFoundException;
import com.example.demoProject.model.EmployeeRequest;
import com.example.demoProject.repository.EmployeeRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServices {
    static Logger logger= LogManager.getLogger(EmployeeServices.class);
    @Autowired
    private EmployeeRepository employeeRepository;

    public String getEmployeeData() throws JsonProcessingException {
        ObjectMapper objectMapper1 = new ObjectMapper();
        List<Employee> emp1 = employeeRepository.findAll();
        String employeesResponseString =objectMapper1.writeValueAsString(emp1);
        System.out.println(employeesResponseString);
        logger.info("Get details of all employee");
        return employeesResponseString;

    }

    public Boolean newEmployeedata(EmployeeRequest employeeRequest) {
        try {
                Employee empl = new Employee();
                if(employeeRequest.getName().isEmpty() || employeeRequest.getName().length()==0){
                    throw new ResourceNotFoundException("Name should not be null or Empty");
                }
                else {

                    empl.setName(employeeRequest.getName());
                    empl.setCompId(employeeRequest.getCompId());
                    Employee savedEmployee = employeeRepository.save(empl);
                    logger.info("Create new employee");
                }
                return true;
        } catch (Exception e) {
            logger.info("Error");
            logger.debug("Error");
            return false;
        }
    }
    public Boolean updatedEmployee(EmployeeRequest employeeRequest) {
        try {
            Optional<Employee> empData = employeeRepository.findById(employeeRequest.getId());
                logger.info("Data is present");
                Employee getDada = empData.get();
                getDada.setId(employeeRequest.getId());
                getDada.setCompId(employeeRequest.getCompId());
                getDada.setName(employeeRequest.getName());
                Employee updateData = employeeRepository.save(getDada);
                return true;
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteEmployeeData(int id) {
        employeeRepository.deleteById(id);
        logger.info("Data is deleted");

    }
}
