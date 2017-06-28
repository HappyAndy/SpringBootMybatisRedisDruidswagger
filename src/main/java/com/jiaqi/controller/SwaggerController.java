package com.jiaqi.controller;

import com.jiaqi.model.User;
import com.wordnik.swagger.annotations.*;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zl on 2015/8/27.
 * <p>
 * http://localhost:8080/swagger/index.html
 */
@Api(value = "product", description = "商品管理", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
@RequestMapping(value = "/users")
public class SwaggerController {


    /**
     * @return
     */
    @ApiOperation(value = "Get all users", notes = "requires noting")
    @RequestMapping(method = RequestMethod.GET)
    public List<User> getUsers() {
        List<User> list = new ArrayList<User>();

        User user = new User();
        user.setUserName("hello");
        list.add(user);

        User user2 = new User();
        user2.setUserName("world");
        list.add(user2);
        return list;
    }

    @ApiOperation(value = "Get user with id", notes = "requires the id of user")
    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public User getUserById(@PathVariable String name) {
        User user = new User();
        user.setUserName(name);
        return user;
    }


    @ApiOperation(value = "获得商品信息", notes = "获取商品信息(用于数据同步)", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "商品信息"),
    @ApiResponse(code = 201, message = "201" + "(token验证失败)", response = String.class),
    @ApiResponse(code = 202, message = "500" + "(系统错误)", response = String.class)})
    @RequestMapping(value = "/detai/{proname}", method = RequestMethod.POST)
    @ResponseBody
    public User getProduct(@ApiParam(value = "json参数", required = true) @PathVariable String proname) throws Exception {
        User user = new User();
        user.setUserName(proname);
        return user;
    }
}
