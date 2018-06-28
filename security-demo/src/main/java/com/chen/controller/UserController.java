package com.chen.controller;

import com.chen.dto.UserDTO;
import com.chen.model.User;
import com.google.common.collect.Lists;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * UserController
 *
 * @Author LeifChen
 * @Date 2018-06-28
 */
@RestController
public class UserController {

    @GetMapping(value = "/user1")
    public List<User> findByName(@RequestParam(name = "name", required = false, defaultValue = "leifchen") String username) {
        System.out.println(username);

        List<User> users = Lists.newArrayList();
        users.add(new User());
        users.add(new User());
        users.add(new User());

        return users;
    }

    @GetMapping(value = "/user2")
    public List<User> query(UserDTO param, @PageableDefault(page = 3, size = 10, sort = "age asc") Pageable pageable) {
        System.out.println(ReflectionToStringBuilder.toString(param, ToStringStyle.MULTI_LINE_STYLE));
        System.out.println(param);

        System.out.println(pageable.getPageNumber());
        System.out.println(pageable.getPageSize());
        System.out.println(pageable.getSort());

        List<User> users = Lists.newArrayList();
        users.add(new User());
        users.add(new User());
        users.add(new User());

        return users;
    }

    @GetMapping(value = "/user/{id}")
    public User getInfo(@PathVariable String id) {
        User user = new User();
        user.setUsername("leifchen");
        return user;
    }

}
