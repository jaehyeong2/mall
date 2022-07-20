package jjfactory.mall.business.domain.report;

import jjfactory.mall.business.domain.BaseTimeEntity;
import jjfactory.mall.business.domain.DeleteStatus;
import jjfactory.mall.business.domain.user.User;
import jjfactory.mall.business.request.report.ReportCreate;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Report extends BaseTimeEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    private User user;

    @OneToOne(fetch = FetchType.LAZY)
    private User reportedUser;

    private String reason;

    @Enumerated(EnumType.STRING)
    private DeleteStatus deleteStatus;

    @Builder
    public Report(User user, User reportedUser, String reason, DeleteStatus deleteStatus) {
        this.user = user;
        this.reportedUser = reportedUser;
        this.reason = reason;
        this.deleteStatus = deleteStatus;
    }

    public static Report create(ReportCreate dto, User user, User reportedUser){
        return Report.builder()
                .user(user)
                .reason(dto.getReason())
                .reportedUser(reportedUser)
                .deleteStatus(DeleteStatus.N)
                .build();
    }

    public void delete() {
        this.deleteStatus = DeleteStatus.Y;
    }
}
