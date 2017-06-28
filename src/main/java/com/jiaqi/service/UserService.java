package com.jiaqi.service;

import com.jiaqi.model.User;
import com.jiaqi.model.User2;

/**
 * Created by zl on 2015/8/27.
 */

/**
 * 用户业务接口层
 * <p>
 * Created by bysocket on 07/02/2017.
 */
public interface UserService {

    public User getUserInfo();

    /**
     * 根据用户名获取用户信息，包括从库的地址信息
     *
     * @param userName
     * @return
     */
    User2 findByName(String userName);
}