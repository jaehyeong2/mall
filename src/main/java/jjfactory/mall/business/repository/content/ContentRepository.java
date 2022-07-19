package jjfactory.mall.business.repository.content;

import jjfactory.mall.business.domain.content.Content;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContentRepository extends JpaRepository<Content,Long> {
}