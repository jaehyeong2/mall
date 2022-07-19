package jjfactory.mall.business.service.comment;

import jjfactory.mall.business.response.comment.CommentDetailRes;
import jjfactory.mall.business.response.comment.CommentRes;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class CommentService {

    @Transactional(readOnly = true)
    public CommentDetailRes findComment(){
        return null;
    }

    @Transactional(readOnly = true)
    public Page<CommentRes> findAllCommentsByContentId(){
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
