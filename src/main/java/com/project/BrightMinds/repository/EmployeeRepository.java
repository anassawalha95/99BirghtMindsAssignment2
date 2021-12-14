package com.project.BrightMinds.repository;

import com.project.BrightMinds.exception.ResourceNotFoundException;
import com.project.BrightMinds.model.Employee;
import com.project.BrightMinds.model.EmploymentType;
import com.project.BrightMinds.projection.EmployeeEmailDTO;
import com.project.BrightMinds.projection.EmployeeFullNameAndTypeDTO;
import com.project.BrightMinds.projection.EmployeeFullNameDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public
interface EmployeeRepository extends JpaRepository<Employee,Long>  {

    List<Employee> findByEmploymentType(EmploymentType type);

    @Query(value = "select CONCAT(e.first_name,' ' ,e.middle_name,' ',e.last_name) as full_name  FROM Employee as e;",nativeQuery = true)
    List<EmployeeFullNameDTO> getAllEmployeesFullNames();

    @Query(value = "select e.email  as email FROM Employee as e;",nativeQuery = true)
    List<EmployeeEmailDTO> getAllEmployeesEmails();

    @Query(value = "select  INITCAP(CONCAT(e.first_name,' ' ,e.middle_name,' ',e.last_name)) as full_name , UPPER(e.employment_type)  as employment_type FROM Employee as e;",nativeQuery = true)
    List<EmployeeFullNameAndTypeDTO> getAllEmployeesFullNamesAndType();

}
