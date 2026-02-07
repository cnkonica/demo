package com.cnkonica.demo.example.controller;

import com.cnkonica.demo.example.common.global.GlobalResponse;
import com.cnkonica.demo.example.common.utils.Results;
import com.cnkonica.demo.example.domain.OrmUser;
import com.cnkonica.demo.example.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("users")
    public GlobalResponse<List<OrmUser>> listUsers() {
        log.info("listUsers");
        return Results.success(userService.getAllUser());
    }

    @GetMapping("users/{id}")
    public GlobalResponse<OrmUser> getUser(@PathVariable("id") long id) {
        log.info("getUser");
        return Results.success(userService.selectByPrimaryKey(id));
    }

    @PostMapping("users")
    public GlobalResponse<OrmUser> createUser(@RequestBody OrmUser user) {
        log.info("createUser");
        return Results.success(userService.create(user));
    }

    @PutMapping("users/{id}")
    public GlobalResponse<OrmUser> updateUser(@PathVariable("id") long id, @RequestBody OrmUser user) {
        log.info("updateUser");
        return Results.success(userService.update(id, user));
    }

    @DeleteMapping("users/{id}")
    public GlobalResponse<Integer> deleteUser(@PathVariable("id") long id) {
        log.info("deleteUser");
        return Results.success(userService.deleteByPrimaryKey(id));
    }
}
