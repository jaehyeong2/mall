package jjfactory.mall.business.response.content;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ContentRes {
    private Long contentId;
    private Long userId;
    private String title;
    private String content;

}
