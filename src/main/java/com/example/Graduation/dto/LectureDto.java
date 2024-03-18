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
    private final String lectureName;
    private final String classDiv;
    private final Domain domain; // 이수구분
    private final int credit;
    private final Department department;
    private final String prof;

    public static class Builder {
        private String lectureName = null;
        private String classDiv = null;
        private Domain domain = null; // 이수구분
        private int credit = 0;
        private Department department = null;
        private String prof = null;

        public Builder() {}
        public Builder lectureName(String lectureName) {
            this.lectureName = lectureName;
            return this;
        }

        public Builder classDiv(String classDiv) {
            this.classDiv = classDiv;
            return this;
        }

        public Builder domain(Domain domain) {
            this.domain = domain;
            return this;
        }

        public Builder credit(int credit) {
            this.credit = credit;
            return this;
        }

        public Builder department(Department department) {
            this.department = department;
            return this;
        }

        public Builder prof(String prof) {
            this.prof = prof;
            return this;
        }

        public LectureDto build() {
            return new LectureDto(this);
        }
    }

    private LectureDto(Builder builder) {
        this.lectureName = builder.lectureName;
        this.classDiv = builder.classDiv;
        this.domain = builder.domain;
        this.credit = builder.credit;
        this.department = builder.department;
        this.prof = builder.prof;
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
