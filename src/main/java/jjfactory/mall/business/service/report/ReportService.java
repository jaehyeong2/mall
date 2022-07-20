package jjfactory.mall.business.service.report;

import jjfactory.mall.business.domain.report.Report;
import jjfactory.mall.business.domain.user.User;
import jjfactory.mall.business.repository.report.ReportRepository;
import jjfactory.mall.business.repository.user.UserRepository;
import jjfactory.mall.business.request.report.ReportCreate;
import jjfactory.mall.business.response.content.ContentDetailRes;
import jjfactory.mall.business.response.content.ContentRes;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Transactional
@Service
public class ReportService {
    private final ReportRepository reportRepository;
    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public ContentDetailRes findContent(){
        return null;
    }

    @Transactional(readOnly = true)
    public Page<ContentRes> findAllContents(){
        return null;
    }


    public String create(ReportCreate dto){
        User user = getUser(dto.getUserId());
        User reportedUser = getUser(dto.getReportedUserId());
        Report report = Report.create(dto, user, reportedUser);
        reportRepository.save(report);
        return "Y";
    }



    public String delete(Long reportId){
        Report report = getReport(reportId);
        report.delete();
        return "Y";
    }

    public String update(){
        return "Y";
    }

    private Report getReport(Long reportId) {
        Report report = reportRepository.findById(reportId).orElseThrow(NoSuchElementException::new);
        return report;
    }

    private User getUser(Long dto) {
        return userRepository.findById(dto).orElseThrow(NoSuchElementException::new);
    }
}
