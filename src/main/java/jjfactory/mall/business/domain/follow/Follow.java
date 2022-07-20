package jjfactory.mall.business.domain.follow;

import jjfactory.mall.business.domain.BaseTimeEntity;
import jjfactory.mall.business.domain.DeleteStatus;
import jjfactory.mall.business.domain.user.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Follow extends BaseTimeEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "user_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @JoinColumn(name = "follower_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private User follower;

    @Enumerated(EnumType.STRING)
    private DeleteStatus deleteStatus;

    public void delete() {
        this.deleteStatus = DeleteStatus.Y;
    }

    @Builder
    public Follow(User user, User follower, DeleteStatus deleteStatus) {
        this.user = user;
        this.follower = follower;
        this.deleteStatus = deleteStatus;
    }

    public static Follow create(User user,User follower){
        return Follow.builder()
                .user(user)
                .follower(follower)
                .deleteStatus(DeleteStatus.N)
                .build();
    }
}
