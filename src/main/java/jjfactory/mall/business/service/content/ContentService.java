package jjfactory.mall.business.service.content;

import jjfactory.mall.business.domain.content.Content;
import jjfactory.mall.business.domain.user.User;
import jjfactory.mall.business.repository.content.ContentQueryRepository;
import jjfactory.mall.business.repository.content.ContentRepository;
import jjfactory.mall.business.repository.user.UserRepository;
import jjfactory.mall.business.request.content.ContentCreate;
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

    private final ContentRepository contentRepository;
    private final ContentQueryRepository contentQueryRepository;
    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public ContentDetailRes findContent(Long contentId){
        Content content = getContent(contentId);
        return new ContentDetailRes(content);
    }

    @Transactional(readOnly = true)
    public Page<ContentRes> findAllContents(){
        return null;
    }

    public String create(ContentCreate dto, User user){
        Content content = Content.create(dto, user);
        contentRepository.save(content);
        return "Y";
    }

    public String delete(Long contentId){
        Content content = getContent(contentId);
        content.delete();
        return "Y";
    }

    public String update(){
        return "Y";
    }

    private Content getContent(Long contentId) {
        Content content = contentRepository.findById(contentId).orElseThrow(IllegalArgumentException::new);
        return content;
    }
}
