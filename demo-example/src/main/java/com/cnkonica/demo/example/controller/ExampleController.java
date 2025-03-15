package com.cnkonica.demo.example.controller;

import com.cnkonica.demo.example.common.global.GlobalResponse;
import com.cnkonica.demo.example.common.utils.Results;
import com.cnkonica.demo.example.domain.OrmUser;
import com.cnkonica.demo.example.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class ExampleController {
    @Autowired
    private UserService userService;

    @Value("${content}")
    private String content;

    @GetMapping("ok")
    public GlobalResponse<String> ok(){
        log.info("this is ok");
        return Results.success();
    }

    @GetMapping("getAllUser")
    public GlobalResponse<List<OrmUser>> getAllUser(){
        log.info("getAllUser...");
        List<OrmUser> allUser = userService.getAllUser();
        return Results.success(allUser);
    }

    @GetMapping("error")
    public GlobalResponse<String> error(){
        log.info("this is error");
        int i = 1/0;
        return Results.success();
    }
    @GetMapping("selectByPrimaryKey")
    public GlobalResponse<OrmUser> selectByPrimaryKey(long id){
        log.info("selectByPrimaryKey");
        OrmUser ormUser = userService.selectByPrimaryKey(id);
        return Results.success(ormUser);
    }
    @GetMapping("getGitConfig")
    public GlobalResponse<String> getGitConfig(){
        log.info("getGitConfig");
        return Results.success(content);
    }

}
