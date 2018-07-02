package com.chen.controller;

import com.chen.exception.UserNoExistException;
import com.chen.vo.UserVO;
import com.chen.model.User;
import com.fasterxml.jackson.annotation.JsonView;
import com.google.common.collect.Lists;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * UserController
 * @Author LeifChen
 * @Date 2018-06-28
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @PostMapping
    public User create(@Valid @RequestBody UserVO param, BindingResult errors) {
        if (errors.hasErrors()) {
            errors.getAllErrors().forEach(error -> System.out.println(error.getDefaultMessage()));
        }

        User user = new User();
        user.setId(1);
        user.setUsername(param.getUsername());
        user.setBirthday(param.getBirthday());
        return user;
    }

    @PutMapping("/{id:\\d+}")
    public User update(@Valid @RequestBody UserVO param, BindingResult errors) {
        if (errors.hasErrors()) {
            errors.getAllErrors().forEach(error -> System.out.println(error.getDefaultMessage()));
        }

        User user = new User();
        user.setId(1);
        user.setUsername(param.getUsername());
        user.setBirthday(param.getBirthday());
        return user;
    }

    @GetMapping
    @JsonView(User.UserSimpleView.class)
    public List<User> findByName(@RequestParam(name = "name", required = false, defaultValue = "leifchen") String username) {
        System.out.println(username);
        List<User> users = Lists.newArrayList();
        users.add(new User());
        users.add(new User());
        users.add(new User());
        return users;
    }

    @GetMapping("/page")
    public List<User> page(UserVO param, @PageableDefault(page = 3, size = 5, sort = "age asc") Pageable pageable) {
        System.out.println(pageable.getPageNumber());
        System.out.println(pageable.getPageSize());
        System.out.println(pageable.getSort());

        List<User> users = Lists.newArrayList();
        users.add(new User());
        users.add(new User());
        users.add(new User());
        return users;
    }

    @GetMapping("/{id:\\d+}")
    @JsonView(User.UserDetailView.class)
    public User getInfo(@PathVariable String id) {
        throw new UserNoExistException(id);
    }
}
