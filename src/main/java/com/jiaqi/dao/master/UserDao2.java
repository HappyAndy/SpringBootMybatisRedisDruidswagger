package com.jiaqi.dao.master;

import com.jiaqi.model.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户 DAO 接口类
 *
 * Created by bysocket on 07/02/2017.
 */
@Mapper
public interface UserDao2 {

    /**
     * 根据用户名获取用户信息
     *
     * @return
     */
    User getUserInfo();
}
