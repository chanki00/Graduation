package com.example.Graduation.domain;

import lombok.Getter;

@Getter
public class Domain {
    private String domainName;
    private DomainName name;
    public Domain(String domain) {
        this.domainName = domain;
    }

    public void classifySubject() { //메모장 확인 (domain.txt)
        /*메모장 보고 코드 작성*/
    }
}
