package jjfactory.mall.business.controller.comment;

import jjfactory.mall.business.response.comment.CommentRes;
import jjfactory.mall.business.service.comment.CommentService;
import jjfactory.mall.global.request.MyPageRequest;
import jjfactory.mall.global.response.ApiPagingResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/comments")
@RestController
public class CommentApi {
    private final CommentService commentService;

    @GetMapping("/{commentId}")
    public ApiPagingResponse<CommentRes> findComments(@RequestParam Long contentId,
                                                      @RequestParam(required = false, defaultValue = "1") int page,
                                                      @RequestParam(required = false,defaultValue = "10") int limit){
        return new ApiPagingResponse<>(commentService.findAllCommentsByContentId(contentId,page,limit));
    }
}
