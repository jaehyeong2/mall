package jjfactory.mall.business.repository.comment;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jjfactory.mall.business.domain.comment.QComment;
import jjfactory.mall.business.response.comment.CommentRes;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

import static jjfactory.mall.business.domain.comment.QComment.*;

@RequiredArgsConstructor
@Repository
public class CommentQueryRepository {
    private final JPAQueryFactory queryFactory;

    public Page<CommentRes> findCommentsByContentId(Pageable pageable,Long contentId){
        List<CommentRes> comments = queryFactory.select(Projections.constructor(CommentRes.class, comment))
                .from(comment)
                .where(comment.content.id.eq(contentId))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        int total = queryFactory.select(Projections.constructor(CommentRes.class, comment))
                .from(comment)
                .where(comment.content.id.eq(contentId)).fetch().size();

        return new PageImpl<>(comments,pageable,total);
    }
}
