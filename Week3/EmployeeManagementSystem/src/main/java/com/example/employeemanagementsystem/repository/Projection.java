package com.example.employeemanagementsystem.repository;

import com.example.employeemanagementsystem.model.Employee;

public @interface Projection {

    Class<Employee>[] types();

    String name();

}
