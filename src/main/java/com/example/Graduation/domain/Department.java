package com.example.Graduation.domain;

import lombok.Getter;

@Getter
public class Department {
    private String name;
    public Department(String department) {
        if(department.isEmpty()) throw new IllegalStateException("학부이름 없음");
        if (department.contains("교양") || department.contains("HRD")) {
            this.name = "공통";
        } else {
            this.name = department;
        }
    }
}

