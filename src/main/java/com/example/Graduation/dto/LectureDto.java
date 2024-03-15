package com.example.Graduation.dto;

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
@Setter
public class LectureDto {
    private String prof;
    private String lectureName;
    private int classDiv;
    private int code; // 이수구분 숫자로
    private String domain; // 이수구분
    private int credit;
    private String department;

    public LectureDto(String prof, String lectureName, int classDiv, String domain, int credit, String department) {
        this.prof = prof;
        this.lectureName = lectureName;
        this.classDiv = classDiv;
        this.credit = credit;
        this.department = department;
        this.domain = domain;
        setDomain(domain);
    }

    public LectureDto() {
    }

    public void setDomain(String domain) {
        this.domain = domain;
        if (domain.contains("HRD")) {
            this.code = 0;
        }
        else if (domain.contains("전공") || domain.contains("학부")) {
            this.code = 2;
        }
        else if (domain.contains("MSC")) {
            this.code = 4;
        }
        else if (domain.contains("교양")) {
            this.code = 6;
        }
        this.code += isRequired(domain);
    }

    public void setProf(String prof) {
        if (prof == "") {
            this.prof = "미정";
        }
        else {
            this.prof = prof;
        }
    }

    public void setDepartment(String department) {
        if (department.contains("교양") || department.contains("HRD")) {
            this.department = "공통";
        }
        else {
            this.department = department;
        }
    }

    private int isRequired(String domain) {
        return domain.contains("필수") ? 0 : 1;
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
