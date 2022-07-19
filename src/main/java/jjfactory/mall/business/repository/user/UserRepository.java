package jjfactory.mall.business.repository.user;

import jjfactory.mall.business.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
