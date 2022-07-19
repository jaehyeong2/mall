package jjfactory.mall.business.domain.comment;

import jjfactory.mall.business.domain.BaseTimeEntity;
import jjfactory.mall.business.domain.DeleteStatus;
import jjfactory.mall.business.domain.user.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class CommentLike extends BaseTimeEntity {

    @Id @GeneratedValue
    private Long id;

    @JoinColumn(name="comment_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Comment comment;

    @JoinColumn(name="sender_id")
    @OneToOne(fetch = FetchType.LAZY)
    private User sender;

    @JoinColumn(name="receiver_id")
    @OneToOne(fetch = FetchType.LAZY)
    private User receiver;

    private int count;

    private Boolean commentLikeType;  // 좋아요 싫어요

    @Enumerated(EnumType.STRING)
    private DeleteStatus deleteStatus;

    public void delete() {
        this.deleteStatus = DeleteStatus.Y;
    }
}
