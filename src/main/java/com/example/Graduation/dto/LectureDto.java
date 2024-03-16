package com.example.Graduation.dto;

import com.example.Graduation.domain.Department;
import com.example.Graduation.domain.Domain;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 교수명 > 15
 * 과목명 > 4
 * 분반 > 5
 * 이수구분 - 코드 > 7
 * 학점 > 8
 * 학부 > 12
 */

/**
 * HRD 필수 - 0
 * HRD 선택 - 1
 * 전공 필수 - 2
 * 전공 선택 - 3
 * MSC 필수 - 4
 * MSC 선택 - 5
 * 교양 필수 - 6
 * 교양 선택 - 7
 * (교양은 아마 영역 별로 따로 나눠야 하나?)
 */

@Getter
public class LectureDto {
    private String lectureName;
    private String classDiv;
    private Domain domain; // 이수구분
    private int credit;
    private Department department;
    private String prof;

    public LectureDto(String lectureName, String classDiv, String domain, int credit, String department,  String prof) {
        this.lectureName = lectureName;
        this.classDiv = classDiv;
        this.domain = new Domain(domain);
        this.credit = credit;
        this.department = new Department(department);
        this.prof = prof;
    }

    public LectureDto() {
    }

    @Override
    public String toString() {
        return "[강의명: " + lectureName +
                ", 교수: " + prof +
                ", 분반: " + classDiv +
                ", 이수구분: " + domain +
                ", 학점: " + credit +
                ", 학부: " + department + "]";
    }
}
