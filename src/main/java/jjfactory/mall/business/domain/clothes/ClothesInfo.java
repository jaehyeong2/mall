package jjfactory.mall.business.domain.clothes;

import jjfactory.mall.business.domain.BaseTimeEntity;
import jjfactory.mall.business.domain.DeleteStatus;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class ClothesInfo extends BaseTimeEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private DeleteStatus deleteStatus;
}
