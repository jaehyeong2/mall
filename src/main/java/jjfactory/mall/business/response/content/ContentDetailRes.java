package jjfactory.mall.business.response.content;

import jjfactory.mall.business.domain.content.Content;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ContentDetailRes {
    private Long contentId;
    private Long userId;
    private String content;
    private LocalDateTime createDate;

    public ContentDetailRes(Content content) {
        this.contentId = content.getId();
        this.userId = content.getUser().getId();
        this.content = content.getContent();
        this.createDate = content.getCreateDate();
    }
}
