package jjfactory.mall.business.service.report;

import jjfactory.mall.business.domain.DeleteStatus;
import jjfactory.mall.business.domain.report.Report;
import jjfactory.mall.business.domain.user.User;
import jjfactory.mall.business.repository.report.ReportRepository;
import jjfactory.mall.business.repository.user.UserRepository;
import jjfactory.mall.business.request.report.ReportCreate;
import jjfactory.mall.global.exception.BusinessException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringBootTest
class ReportServiceTest {

    @Autowired
    ReportService reportService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ReportRepository reportRepository;

    @Test
    void findContent() {
    }

    @Test
    void findAllContents() {
    }

    @Test
    @DisplayName("유저 신고 성공")
    void create() {
        //given
        User kim222 = User.builder().username("kim222").build();
        User kim333 = User.builder().username("kim333").build();
        userRepository.saveAll(List.of(kim222,kim333));

        ReportCreate dto = ReportCreate.builder()
                .userId(kim222.getId())
                .reportedUserId(kim333.getId())
                .reason("음란물 게시")
                .build();

        //when
        reportService.create(dto);
        List<String> reportedUsernames = reportRepository.findAll().stream()
                .map(e -> e.getReportedUser().getUsername()).collect(Collectors.toList());

        //then
        assertThat(reportRepository.count()).isEqualTo(1);
        assertThat(reportedUsernames).contains("kim333");

    }

    @Test
    @DisplayName("사유 null이거나 빈값이면 유저 신고 exception")
    void createExeption() {
        //given
        User kim222 = User.builder().username("kim222").build();
        User kim333 = User.builder().username("kim333").build();
        userRepository.saveAll(List.of(kim222,kim333));

        ReportCreate dto = ReportCreate.builder()
                .userId(kim222.getId())
                .reportedUserId(kim333.getId())
                .reason("  ")
                .build();

        //expected
        assertThatThrownBy(() -> reportService.create(dto))
                .isInstanceOf(BusinessException.class);

    }

    @Test
    @DisplayName("신고 삭제 테스트")
    void delete() {
        //given
        User kim222 = User.builder().username("kim222").build();
        User kim333 = User.builder().username("kim333").build();
        userRepository.saveAll(List.of(kim222,kim333));

        Report report = Report.builder().user(kim222).reportedUser(kim333)
                .reason("욕설").build();
        reportRepository.save(report);

        //when
        reportService.delete(report.getId());

        //then
        assertThat(report.getDeleteStatus()).isEqualTo(DeleteStatus.Y);
    }

    @Test
    void update() {
    }
}