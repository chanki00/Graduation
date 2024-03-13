package com.example.Graduation.crawler;

import com.example.Graduation.dto.NoticeDto;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Crawler {
    public static List<NoticeDto> getNotice() throws IOException {
        List<NoticeDto> list = new ArrayList<>();

        String aunuriURL = "https://portal.koreatech.ac.kr/ctt/bb/bulletin?b=14";

        Document doc = Jsoup.connect(aunuriURL).get();

        Elements titles = doc.select(".bc-s-title span");

        for (int i=0; i<titles.size(); ++i) {
            Element title = titles.get(i);
            String titleStr = title.text();
            NoticeDto dto = new NoticeDto(titleStr);
            list.add(dto);
        }

        return list;
    }
}

