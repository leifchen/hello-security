package com.chen.controller;

import com.chen.model.User;
import com.chen.vo.UserVO;
import com.fasterxml.jackson.annotation.JsonView;
import com.google.common.collect.Lists;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * UserController
 *
 * @Author LeifChen
 * @Date 2018-06-28
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/me")
    @ApiOperation("查看当前登录用户信息")
    public Object getCurrentUser(@AuthenticationPrincipal UserDetails user) {
        return user;
    }

    @PostMapping
    @ApiOperation("创建用户")
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
    @ApiOperation("修改用户")
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
    @ApiOperation("根据用户名查找用户")
    public List<User> findByName(@ApiParam("用户名") @RequestParam(name = "name", required = false, defaultValue = "leifchen") String username) {
        System.out.println(username);
        List<User> users = Lists.newArrayList();
        users.add(new User());
        users.add(new User());
        users.add(new User());
        return users;
    }

    @GetMapping("/page")
    @ApiOperation("分页显示用户列表")
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
    @ApiOperation("查看用户详细信息")
    @JsonView(User.UserDetailView.class)
    public User getInfo(@ApiParam("用户id") @PathVariable String id) {
        // throw new UserNoExistException(id);
        System.out.println("进入getInfo");
        User user = new User();
        user.setUsername("leifchen");
        return user;
    }
}
