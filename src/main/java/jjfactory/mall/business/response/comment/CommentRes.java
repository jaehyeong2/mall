package jjfactory.mall.business.response.comment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CommentRes {
    private Long commentId;
    private Long userId;
    private String content;
}
