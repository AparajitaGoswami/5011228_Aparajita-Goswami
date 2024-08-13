package com.example.employeemanagementsystem.repository;

import com.example.employeemanagementsystem.dto.EmployeeDto;
import com.example.employeemanagementsystem.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("SELECT e.id AS id, e.name AS name FROM Employee e")
    List<EmployeeProjection> findAllEmployeeProjections();

    @Query("SELECT new com.example.employeemanagementsystem.dto.EmployeeDto(e.id, e.name) FROM Employee e")
    List<EmployeeDto> findAllEmployeeDtos();

    @Query("SELECT e FROM Employee e WHERE e.department.name = :departmentName")
    List<Employee> findEmployeesByDepartmentName(@Param("departmentName") String departmentName);

    @Query("SELECT e FROM Employee e WHERE e.department.name = :departmentName")
    Page<Employee> findEmployeesByDepartmentName(@Param("departmentName") String departmentName, Pageable pageable);

    void clear();
}
