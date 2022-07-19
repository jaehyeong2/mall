package jjfactory.mall.business.repository.content;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jjfactory.mall.business.domain.DeleteStatus;
import jjfactory.mall.business.domain.content.QContent;
import jjfactory.mall.business.response.content.ContentRes;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

import static jjfactory.mall.business.domain.content.QContent.*;

@RequiredArgsConstructor
@Repository
public class ContentQueryRepository {
    private final JPAQueryFactory queryFactory;

    public Page<ContentRes> findAllContents(Pageable pageable){
        List<ContentRes> contents = queryFactory.select(Projections.constructor(ContentRes.class, content1))
                .from(content1)
                .where(content1.deleteStatus.eq(DeleteStatus.N))
                .orderBy(content1.createDate.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        int total = queryFactory.select(Projections.constructor(ContentRes.class, content1))
                .from(content1)
                .where(content1.deleteStatus.eq(DeleteStatus.N))
                .fetch().size();

        return new PageImpl<>(contents,pageable,total);
    }

}
