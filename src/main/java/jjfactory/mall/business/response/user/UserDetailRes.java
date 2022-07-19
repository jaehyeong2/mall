package jjfactory.mall.business.response.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserDetailRes {
    private Long userId;
    private String email;
    private String password;
    private String name;
}
