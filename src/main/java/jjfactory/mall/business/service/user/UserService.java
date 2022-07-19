package jjfactory.mall.business.service.user;

import jjfactory.mall.business.response.user.UserDetailRes;
import jjfactory.mall.business.response.user.UserRes;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class UserService {

    @Transactional(readOnly = true)
    public UserDetailRes findUser(){
        return null;
    }

    @Transactional(readOnly = true)
    public Page<UserRes> findAllUser(){
        return null;
    }

    public String create(){
        return "Y";
    }

    public String delete(){
        return "Y";
    }

    public String update(){
        return "Y";
    }
}
