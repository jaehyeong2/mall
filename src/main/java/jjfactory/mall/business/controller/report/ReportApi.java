package jjfactory.mall.business.controller.report;

import jjfactory.mall.business.service.report.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/reports")
@RestController
public class ReportApi {
    private final ReportService reportService;
}
