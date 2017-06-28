package com.jiaqi.dao.master;

import com.jiaqi.model.Puser;
import com.jiaqi.model.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户 DAO 接口类
 *
 * Created by bysocket on 07/02/2017.
 */
@Mapper
public interface PuserDao {

    /**
     * 根据用户名获取用户信息
     *
     * @return
     */
    Puser getUserInfo();
}
