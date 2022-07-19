package jjfactory.mall.business.response.content;

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
}
