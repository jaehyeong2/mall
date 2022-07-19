package jjfactory.mall.business.domain.user;

import jjfactory.mall.business.domain.BaseTimeEntity;
import jjfactory.mall.business.domain.DeleteStatus;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class User extends BaseTimeEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String username;
    private String password;
    private String email;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    private DeleteStatus deleteStatus;

    @Builder

    public User(String name, String username, String password, String email, Gender gender, Address address, DeleteStatus deleteStatus) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.gender = gender;
        this.address = address;
        this.deleteStatus = deleteStatus;
    }

    public void delete() {
        this.deleteStatus = DeleteStatus.Y;
    }
}
