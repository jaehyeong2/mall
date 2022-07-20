package jjfactory.mall.business.service.report;

import jjfactory.mall.business.domain.user.User;
import jjfactory.mall.business.repository.report.ReportRepository;
import jjfactory.mall.business.repository.user.UserRepository;
import jjfactory.mall.business.request.report.ReportCreate;
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
    void delete() {
    }

    @Test
    void update() {
    }
}