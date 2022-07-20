package jjfactory.mall.business.service.content;

import jjfactory.mall.business.response.content.ContentDetailRes;
import jjfactory.mall.business.response.content.ContentRes;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class ContentService {

    @Transactional(readOnly = true)
    public ContentDetailRes findContent(){
        return null;
    }

    @Transactional(readOnly = true)
    public Page<ContentRes> findAllContents(){
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
