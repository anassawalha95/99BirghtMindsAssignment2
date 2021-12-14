package com.project.BrightMinds.controller;

import com.project.BrightMinds.exception.ResourceNotFoundException;
import com.project.BrightMinds.exception.WrongDataProvided;
import com.project.BrightMinds.model.Employee;
import com.project.BrightMinds.model.EmploymentType;
import com.project.BrightMinds.projection.EmployeeEmailDTO;
import com.project.BrightMinds.projection.EmployeeFullNameAndTypeDTO;
import com.project.BrightMinds.projection.EmployeeFullNameDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.project.BrightMinds.repository.EmployeeRepository;
import java.util.List;


@RestController
@RequestMapping(value="/api/v1/employees")
public
class EmployeeController {




    @Autowired
    private EmployeeRepository employeeRepository;


    private static final Logger LOGGER=  LoggerFactory.getLogger(EmployeeController.class);


    @GetMapping(value="/type",  produces = MediaType.APPLICATION_JSON_VALUE)
    public
    List<Employee> getEmployeesBasedOnEmploymentType(@RequestParam(name = "type") String type) throws ResourceNotFoundException, WrongDataProvided {
        boolean flag=true;
        EmploymentType validatedType = null;
        for(EmploymentType t: EmploymentType.values()){
            if (t.name()
                    .equals(type)){
               flag=false;
               validatedType=t;

               break;

            }
        }

        if (flag) {
            LOGGER.info("User Entered Wrong Type in getEmployeesBasedOnEmploymentType");
            throw new WrongDataProvided("The Provided Type must be INTERN, PERMANENT,OR CONTRACT");
        }


        List<Employee> employees= employeeRepository.findByEmploymentType(validatedType);
        if (!employees.isEmpty()) {
            LOGGER.info("Data Found in getEmployeesBasedOnEmploymentType");
            return employees;
        }
        else {
            LOGGER.warn("User Found No Data in getEmployeesBasedOnEmploymentType");
            throw new ResourceNotFoundException("No Data Found");
        }


    }

    @GetMapping("/names")
    public
    List<EmployeeFullNameDTO> getAllEmployeesFullName() throws ResourceNotFoundException {

        List<EmployeeFullNameDTO> employees= employeeRepository.getAllEmployeesFullNames();

        if (!employees.isEmpty()) {

            LOGGER.info("Data Found in getAllEmployeesFullName");
            return employees;
        }
        else {
            LOGGER.warn("User Found No Data in getAllEmployeesFullName");
            throw new ResourceNotFoundException("No Data Found");
        }


    }
//
//
    @GetMapping("/emails")
    public
    List<EmployeeEmailDTO> getAllEmployeesEmails() throws ResourceNotFoundException{

           List<EmployeeEmailDTO> employees= employeeRepository.getAllEmployeesEmails();

        if (!employees.isEmpty()){

            LOGGER.info("Data Found in getAllEmployeesEmails");
            return employees;
        }

        else {
            LOGGER.warn("Data Found in getAllEmployeesEmails");
            throw new ResourceNotFoundException("No Data Found");
        }


    }

    @GetMapping("/names/types")
    public
    List<EmployeeFullNameAndTypeDTO> getAllEmployeesFullNameAndTypes() throws ResourceNotFoundException{

        List<EmployeeFullNameAndTypeDTO> employees= employeeRepository.getAllEmployeesFullNamesAndType();

        if (!employees.isEmpty()) {
            LOGGER.info("Data Found in getAllEmployeesFullNameAndTypes");
            return employees;
        }
        else{
            LOGGER.warn("Data Found in getAllEmployeesFullNameAndTypes");
            throw new ResourceNotFoundException("No Data Found");
        }


    }


}
