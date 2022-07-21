package jjfactory.mall.business.controller.comment;

import jjfactory.mall.business.request.comment.CommentCreate;
import jjfactory.mall.business.response.comment.CommentRes;
import jjfactory.mall.business.service.comment.CommentService;
import jjfactory.mall.global.request.MyPageRequest;
import jjfactory.mall.global.response.ApiPagingResponse;
import jjfactory.mall.global.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/")
    public ApiResponse<String> createComment(@RequestBody CommentCreate dto,@RequestParam Long contentId){
        return new ApiResponse<>(commentService.create(dto,null,contentId));
    }

    @DeleteMapping("/{commentId}")
    public ApiResponse<String> deleteComment(@PathVariable Long commentId){
        return new ApiResponse<>(commentService.delete(commentId));
    }
}
