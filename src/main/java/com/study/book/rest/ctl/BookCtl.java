package com.study.book.rest.ctl;

import com.study.book.rest.dto.ReqBookParams;
import com.study.book.rest.dto.ResBook;
import com.study.book.rest.svr.itf.BookSvrItf;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/rest/book")
public class BookCtl {

    private final BookSvrItf bookSvr;

    @Autowired
    public BookCtl(BookSvrItf bookSvr) {
        this.bookSvr = bookSvr;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<ResBook> list(ReqBookParams params){
        log.info("[정보] params : {}", params.toString());
        return new ResponseEntity<>(this.bookSvr.list(params), HttpStatus.OK);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<ResBook> save(ReqBookParams params){
        log.info("[정보] params : {}", params.toString());
        return new ResponseEntity<>(this.bookSvr.save(params), HttpStatus.OK);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public ResponseEntity<ResBook> delete(ReqBookParams params){
        log.info("[정보] params : {}", params.toString());
        return new ResponseEntity<>(this.bookSvr.delete(params), HttpStatus.OK);
    }

    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public ResponseEntity<ResBook> detail(ReqBookParams params){
        log.info("[정보] params : {}", params.toString());
        return new ResponseEntity<>(this.bookSvr.detail(params), HttpStatus.OK);
    }

}
