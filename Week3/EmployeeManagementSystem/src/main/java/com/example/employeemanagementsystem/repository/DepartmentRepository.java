package com.example.employeemanagementsystem.repository;

import com.example.employeemanagementsystem.dto.DepartmentDto;
import com.example.employeemanagementsystem.model.Department;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    @Query("SELECT d.id AS id, d.name AS name FROM Department d")
    List<DepartmentProjection> findAllDepartmentProjections();

    @Query("SELECT new com.example.employeemanagementsystem.dto.DepartmentDto(d.id, d.name) FROM Department d")
    List<DepartmentDto> findAllDepartmentDtos();

    Department findByName(@Param("name") String name);
}
