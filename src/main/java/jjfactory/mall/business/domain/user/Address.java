package jjfactory.mall.business.domain.user;

import lombok.Getter;

import javax.persistence.Embeddable;

@Getter
@Embeddable
public class Address {
    private String post;
    private String street;
    private String zipCode;
}
