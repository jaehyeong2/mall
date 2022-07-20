package jjfactory.mall.global.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.PageRequest;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class MyPageRequest {
    private int page;
    private int size;

    public PageRequest of(){
        return PageRequest.of(page-1,size);
    }
}
