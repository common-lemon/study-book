package com.study.book.rest.dto;

import com.study.book.rest.model.BookEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class ResBook {

    private List<BookEntity> bookList;
    private BookEntity bookEntity;

    private String ResCode;
    private String ResMsg;
    private String ResErr;

}
