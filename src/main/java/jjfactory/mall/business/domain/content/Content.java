package jjfactory.mall.business.domain.content;

import jjfactory.mall.business.domain.BaseTimeEntity;
import jjfactory.mall.business.domain.DeleteStatus;
import jjfactory.mall.business.domain.user.User;
import jjfactory.mall.business.request.content.ContentCreate;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Content extends BaseTimeEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "user_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "content")
    private List<ContentImage> contentImages = new ArrayList<>();

    private String title;

    @Lob
    private String content;

    @Enumerated(EnumType.STRING)
    private DeleteStatus deleteStatus;

    @Builder
    public Content(User user, List<ContentImage> contentImages, String title, String content, DeleteStatus deleteStatus) {
        this.user = user;
        this.contentImages = contentImages;
        this.title = title;
        this.content = content;
        this.deleteStatus = deleteStatus;
    }

    public static Content create(ContentCreate dto,User user){
        return Content.builder()
                .content(dto.getContent())
                .title(dto.getTitle())
                .user(user)
                .deleteStatus(DeleteStatus.N)
                .build();
    }

    public void delete() {
        this.deleteStatus = DeleteStatus.Y;
    }

}
