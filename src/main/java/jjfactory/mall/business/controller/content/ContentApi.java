package jjfactory.mall.business.controller.content;

import jjfactory.mall.business.service.content.ContentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/contents")
@RestController
public class ContentApi {
    private final ContentService contentService;
}
