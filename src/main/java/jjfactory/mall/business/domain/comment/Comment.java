package jjfactory.mall.business.domain.comment;

import jjfactory.mall.business.domain.BaseTimeEntity;
import jjfactory.mall.business.domain.DeleteStatus;
import jjfactory.mall.business.domain.content.Content;
import jjfactory.mall.business.domain.user.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Comment extends BaseTimeEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "user_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @JoinColumn(name = "content_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Content content;

    private String commentContent;

    @Enumerated(EnumType.STRING)
    private DeleteStatus deleteStatus;

    public void delete() {
        this.deleteStatus = DeleteStatus.Y;
    }
}
