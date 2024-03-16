package com.example.Graduation.crawler;

import com.example.Graduation.domain.ExcelFile;
import com.example.Graduation.dto.LectureDto;
import lombok.Getter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.util.ArrayList;

@Getter
public class LectureCrawler {
    public static ArrayList<LectureDto> crawlLecture() {
        ArrayList<LectureDto> lectures = new ArrayList<>();
        try {
            FileInputStream lectureListFile = new FileInputStream(ExcelFile.FILENAME);
            XSSFWorkbook workbook = new XSSFWorkbook(lectureListFile);
            XSSFSheet lectureListSheet = workbook.getSheetAt(0); //0번째 시트만

            int firstRowIdx = lectureListSheet.getFirstRowNum();
            int lastRowIdx = lectureListSheet.getLastRowNum();

            for (int i=firstRowIdx+1; i<=lastRowIdx; ++i) {
                //for (int i=firstRowIdx+1; i<=10; ++i) {
                XSSFRow row = lectureListSheet.getRow(i);
                if (row != null) {
                    int lectureNameColumn = 4;
                    int classDivColumn = 5;
                    int domainColumn = 7; //대표이수구분
                    int creditColumn = 8; //학점
                    int departmentColumn = 12; //개설학부
                    int profColumn = 15; //담당교수

                    String lectureName = row.getCell(lectureNameColumn).getStringCellValue();
                    String classDiv = row.getCell(classDivColumn).getStringCellValue();
                    String domain = row.getCell(domainColumn).getStringCellValue();
                    int credit = (int) row.getCell(creditColumn).getNumericCellValue();
                    String department = row.getCell(departmentColumn).getStringCellValue();
                    String prof = row.getCell(profColumn).getStringCellValue();

                    LectureDto lecture = new LectureDto(lectureName, classDiv, domain, credit, department, prof);
                    lectures.add(lecture);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lectures;
    }
}
