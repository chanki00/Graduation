package com.example.Graduation.dto;

public class NoticeDto {
    private String title;

    public NoticeDto() {}

    public NoticeDto(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "제목: " + title;
    }
}
