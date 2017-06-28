package com.jiaqi.service.impl;

import com.jiaqi.dao.cluster.CityDao;
import com.jiaqi.dao.master.UserDao;
import com.jiaqi.dao.master.UserDao2;
import com.jiaqi.model.City;
import com.jiaqi.model.User;
import com.jiaqi.model.User2;
import com.jiaqi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户业务实现层
 *
 * Created by bysocket on 07/02/2017.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao; // 主数据源

    @Autowired
    private UserDao2 userDao2; // 主数据源

    @Autowired
    private CityDao cityDao; // 从数据源

    @Override
    public User getUserInfo() {


        return userDao2.getUserInfo();
    }

    @Override
    public User2 findByName(String userName) {
        User2 user = userDao.findByName(userName);
        City city = cityDao.findByName("温岭市");
        user.setCity(city);
        return user;
    }
}
