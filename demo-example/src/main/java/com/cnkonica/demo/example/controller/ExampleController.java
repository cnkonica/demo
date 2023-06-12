package com.cnkonica.demo.example.controller;

import com.cnkonica.demo.example.common.global.GlobalResponse;
import com.cnkonica.demo.example.common.utils.Results;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ExampleController {
    @GetMapping("ok")
    public GlobalResponse<String> ok(){
        log.info("this is ok");
        return Results.success();
    }
}
