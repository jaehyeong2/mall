package jjfactory.mall.business.request.user;

import jjfactory.mall.business.domain.user.Address;
import jjfactory.mall.business.domain.user.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserUpdate {
    private String email;
    private String password;
    private String name;
    private String username;
    private Gender gender;
    private Address address;
}
