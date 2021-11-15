package com.study.book.rest.svr;

import com.study.book.rest.dto.ReqBookParams;
import com.study.book.rest.dto.ResBook;
import com.study.book.rest.model.BookEntity;
import com.study.book.rest.repo.BookRepository;
import com.study.book.rest.svr.itf.BookSvrItf;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Slf4j
@Service("bookSvr")
public class BookSvrImpl implements BookSvrItf {

    private BookRepository bookRepository;

    @Autowired
    public BookSvrImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public ResBook list(ReqBookParams reqBookParams) {

        ResBook resBook = new ResBook();
        resBook.setResCode("S-001");
        resBook.setResMsg("정상 처리 되었습니다.");
        if(StringUtils.hasText(reqBookParams.getTitle())){
            resBook.setBookList(this.bookRepository.findByTitleContains(reqBookParams.getTitle()));
        }
        else{
            resBook.setBookList(this.bookRepository.findAll());
        }

        return resBook;

    }

    @Override
    public ResBook save(ReqBookParams reqBookParams) {

        ResBook resBook = new ResBook();
        resBook.setResCode("S-001");
        resBook.setResMsg("정상 처리 되었습니다.");

        BookEntity bookEntity = new BookEntity();
        BeanUtils.copyProperties(reqBookParams, bookEntity);
        try {
            resBook.setBookEntity(this.bookRepository.save(bookEntity));
        }
        catch (Exception e){
            log.error(e.getMessage(), e);
            resBook.setResErr(e.getMessage());
            resBook.setResCode("F-001");
            resBook.setResMsg("요청하신 작업이 실패하였습니다.");
        }

        return resBook;
    }

    @Override
    public ResBook delete(ReqBookParams reqBookParams) {

        ResBook resBook = new ResBook();
        resBook.setResCode("S-001");
        resBook.setResMsg("정상 처리 되었습니다.");

        try {
            this.bookRepository.deleteById(reqBookParams.getId());
        }
        catch (Exception e){
            log.error(e.getMessage(), e);
            resBook.setResErr(e.getMessage());
            resBook.setResCode("F-001");
            resBook.setResMsg("요청하신 작업이 실패하였습니다.");
        }

        return resBook;
    }

    @Override
    public ResBook detail(ReqBookParams reqBookParams) {
        ResBook resBook = new ResBook();
        resBook.setResCode("S-001");
        resBook.setResMsg("정상 처리 되었습니다.");

        resBook.setBookEntity(this.bookRepository.findById(reqBookParams.getId()).orElse(null));

        return resBook;
    }
}
