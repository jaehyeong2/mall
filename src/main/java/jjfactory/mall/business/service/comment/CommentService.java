package jjfactory.mall.business.service.comment;

import jjfactory.mall.business.domain.comment.Comment;
import jjfactory.mall.business.domain.content.Content;
import jjfactory.mall.business.domain.user.User;
import jjfactory.mall.business.repository.comment.CommentQueryRepository;
import jjfactory.mall.business.repository.comment.CommentRepository;
import jjfactory.mall.business.repository.content.ContentRepository;
import jjfactory.mall.business.repository.user.UserRepository;
import jjfactory.mall.business.request.comment.CommentCreate;
import jjfactory.mall.business.request.comment.CommentUpdate;
import jjfactory.mall.business.response.comment.CommentDetailRes;
import jjfactory.mall.business.response.comment.CommentRes;
import jjfactory.mall.global.request.MyPageRequest;
import jjfactory.mall.global.response.PagingResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Transactional
@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final CommentQueryRepository commentQueryRepository;
    private final ContentRepository contentRepository;
    private final UserRepository userRepository;


    //TODO 내가작성한 댓글보기
    @Transactional(readOnly = true)
    public CommentDetailRes findComment(){
        return null;
    }

    @Transactional(readOnly = true)
    public PagingResponse<CommentRes> findAllCommentsByContentId(Long commentId, int page, int limit){
        Pageable pageRequest = new MyPageRequest(page,limit).of();
        Page<CommentRes> comments = commentQueryRepository.findCommentsByContentId(pageRequest, commentId);
        return new PagingResponse<>(comments);
    }

    public String create(CommentCreate dto, Long userId, Long contentId){
        User user = userRepository.findById(userId).orElseThrow(NoSuchElementException::new);
        Content content = contentRepository.findById(contentId).orElseThrow(NoSuchElementException::new);

        Comment comment = Comment.create(user, content, dto);
        commentRepository.save(comment);
        return "Y";
    }

    public String delete(Long commentId){
        Comment comment = getComment(commentId);
        comment.delete();
        return "Y";
    }

    public String update(Long commentId, CommentUpdate dto){
        Comment comment = getComment(commentId);
        comment.updateContent(dto.getContent());
        return "Y";
    }

    private Comment getComment(Long commentId) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(NoSuchElementException::new);
        return comment;
    }
}
