package com.jiaqi.service.impl;

import com.jiaqi.config.jedis.RedisClientTemplate;
import com.jiaqi.dao.cluster.CityDao;
import com.jiaqi.dao.master.UserDao;
import com.jiaqi.model.City;
import com.jiaqi.model.User;
import com.jiaqi.service.UserService;
import com.jiaqi.utils.protostuff.ProtoStuffSerializerUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户业务实现层
 * <p>
 * Created by bysocket on 07/02/2017.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao; // 主数据源


    @Autowired
    private CityDao cityDao; // 从数据源

    @Autowired
    private RedisClientTemplate redisClientTemplate; // 从数据源

    private static Logger logger = Logger.getLogger(UserServiceImpl.class);

    @Override
    public User findByName(String userName) {
        String key = "findByName:name:" + userName;
      /*
      * 使用 protostuff 序列化
      * */
        try {
            boolean flag = redisClientTemplate.exists(key.getBytes());
            logger.info("缓存中数据是否存在：" + flag);
            if (flag) {
                byte[] userBytes = redisClientTemplate.get(key.getBytes());
                logger.info("读取缓存数据");
                return ProtoStuffSerializerUtil.deserialize(userBytes, User.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        User user = userDao.findByName(userName);
        City city = cityDao.findByName("温岭市");
        user.setCity(city);
        try {
            byte[] bytes = ProtoStuffSerializerUtil.serialize(user);
            logger.info("序列化成功");
            redisClientTemplate.set(key.getBytes(), 60, bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
}
