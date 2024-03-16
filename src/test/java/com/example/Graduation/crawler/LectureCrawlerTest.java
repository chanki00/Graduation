package com.example.Graduation.crawler;

import com.example.Graduation.dto.LectureDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
class LectureCrawlerTest {
  @Test
  public void 엑셀_첫줄_테스트() {
      // given
      ArrayList<LectureDto> lectures = LectureCrawler.crawlLecture();
      // when
      LectureDto firstLecture = lectures.get(0);
      // then
      Assertions.assertThat(firstLecture.getLectureName()).isEqualTo("교육봉사활동");
      Assertions.assertThat(firstLecture.getClassDiv()).isEqualTo("01");
      Assertions.assertThat(firstLecture.getDomain().getDomainName()).isEqualTo("HRD선택");
      Assertions.assertThat(firstLecture.getCredit()).isEqualTo(2);
      Assertions.assertThat(firstLecture.getDepartment().getName()).isEqualTo("공통");
      Assertions.assertThat(firstLecture.getProf()).isEqualTo("윤관식");
  }

    @Test
    public void 엑셀_마지막줄_테스트() {
        // given
        ArrayList<LectureDto> lectures = LectureCrawler.crawlLecture();
        // when
        LectureDto firstLecture = lectures.get(lectures.size() - 1);
        // then
        Assertions.assertThat(firstLecture.getLectureName()).isEqualTo("과학기술과 지식재산");
        Assertions.assertThat(firstLecture.getClassDiv()).isEqualTo("01");
        Assertions.assertThat(firstLecture.getDomain().getDomainName()).isEqualTo("일반교양선택");
        Assertions.assertThat(firstLecture.getCredit()).isEqualTo(2);
        Assertions.assertThat(firstLecture.getDepartment().getName()).isEqualTo("컴퓨터공학부");
        Assertions.assertThat(firstLecture.getProf()).isEqualTo("이강환");
    }
}