package com.jiaqi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2017/6/28.
 * 多环境属性配置文件情况下，测试当前环境启动读取那个配置文件。
 */

@Controller
public class TestProfiles {
    @Autowired
    private Environment env;

    @RequestMapping("/testProfile")
    @ResponseBody
    public String testProfile() {
        return env.getProperty("profile");
    }


}
