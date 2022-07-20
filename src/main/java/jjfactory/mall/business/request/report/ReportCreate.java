package jjfactory.mall.business.request.report;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class ReportCreate {
    private Long reportedUserId;
    private Long userId;
    private String reason;

    @Builder
    public ReportCreate(Long reportedUserId, Long userId, String reason) {
        this.reportedUserId = reportedUserId;
        this.userId = userId;
        this.reason = reason;
    }
}
