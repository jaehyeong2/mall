package jjfactory.mall.business.request.content;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ContentCreate {
    private String title;
    private String content;
}
