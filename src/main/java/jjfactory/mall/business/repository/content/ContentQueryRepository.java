package jjfactory.mall.business.repository.content;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class ContentQueryRepository {
    private final JPAQueryFactory queryFactory;


}
