package com.example.Graduation.crawler;

import com.example.Graduation.constants.Constants;
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
            FileInputStream lectureListFile = new FileInputStream(Constants.FILENAME);
            XSSFWorkbook workbook = new XSSFWorkbook(lectureListFile);
            XSSFSheet lectureListSheet = workbook.getSheetAt(0);

            int firstRowIdx = lectureListSheet.getFirstRowNum();
            int lastRowIdx = lectureListSheet.getLastRowNum();

            for (int i=firstRowIdx+1; i<=lastRowIdx; ++i) {
                //for (int i=firstRowIdx+1; i<=10; ++i) {
                XSSFRow row = lectureListSheet.getRow(i);
                if (row != null) {
                    LectureDto lecture = new LectureDto();
                    lecture.setProf(row.getCell(15).getStringCellValue());
                    lecture.setLectureName(row.getCell(4).getStringCellValue());
                    lecture.setClassDiv(Integer.parseInt(row.getCell(5).getStringCellValue()));
                    lecture.setDomain(row.getCell(7).getStringCellValue());
                    lecture.setCredit((int) row.getCell(8).getNumericCellValue());
                    lecture.setDepartment(row.getCell(12).getStringCellValue());
                    lectures.add(lecture);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lectures;
    }
}
