package jjfactory.mall.business.repository.comment;

import jjfactory.mall.business.domain.comment.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Long> {
}