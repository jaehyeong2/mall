package jjfactory.mall.business.service.board;

import jjfactory.mall.business.response.content.ContentDetailRes;
import jjfactory.mall.business.response.content.ContentRes;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class BoardService {

    @Transactional(readOnly = true)
    public ContentDetailRes findBoard(){
        return null;
    }

    @Transactional(readOnly = true)
    public Page<ContentRes> findAllBoards(){
        return null;
    }

    public String create(){
        return "Y";
    }

    public String delete(){
        return "Y";
    }

    public String update(){
        return "Y";
    }
}
