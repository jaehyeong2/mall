package jjfactory.mall.business.domain.comment;

import jjfactory.mall.business.domain.BaseTimeEntity;
import jjfactory.mall.business.domain.DeleteStatus;
import jjfactory.mall.business.domain.content.Content;
import jjfactory.mall.business.domain.user.User;
import jjfactory.mall.business.request.comment.CommentCreate;
import lombok.AccessLevel;
import lombok.Builder;
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

    @Column(name = "content")
    private String commentContent;

    @Enumerated(EnumType.STRING)
    private DeleteStatus deleteStatus;

    @Builder
    public Comment(User user, Content content, String commentContent, DeleteStatus deleteStatus) {
        this.user = user;
        this.content = content;
        this.commentContent = commentContent;
        this.deleteStatus = deleteStatus;
    }

    public static Comment create(User user, Content content, CommentCreate dto){
        return Comment.builder()
                .user(user)
                .content(content)
                .commentContent(dto.getContent())
                .deleteStatus(DeleteStatus.N)
                .build();
    }

    public void updateContent(String content) {
        this.commentContent = content;
    }

    public void delete() {
        this.deleteStatus = DeleteStatus.Y;
    }
}
