package jjfactory.mall.business.response.report;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ReportRes {
    private Long userId;
    private Long reportedUserId;
    private String reason;
}
