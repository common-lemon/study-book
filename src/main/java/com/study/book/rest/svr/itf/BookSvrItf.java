package com.study.book.rest.svr.itf;

import com.study.book.rest.dto.ReqBookParams;
import com.study.book.rest.dto.ResBook;

public interface BookSvrItf {

    ResBook list(ReqBookParams reqBookParams);

    ResBook save(ReqBookParams reqBookParams);

    ResBook delete(ReqBookParams reqBookParams);

    ResBook detail(ReqBookParams reqBookParams);
    
}
