package com.example.employeemanagementsystem.dto;

public class EmployeeDto {
    private long id;
    private String name;

    // Constructor with parameters matching the query
    public EmployeeDto(long id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getters and setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
