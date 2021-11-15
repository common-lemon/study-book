package com.study.book.rest.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ReqBookParams {

    private Long id;
    private String bookNo;
    private String deptName;
    private String title;
    private String registerNm;
    private String publisher;
    private String bookPrice;
    private String regRsn;
    private int count;

}
