package com.ty.tymockdemo.controller;

import com.ty.tymockdemo.service.TyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description :
 * @Author : 田迎
 * @Date : 2023/3/25 23:05
 * @Version : 1.0.0
 **/

@RestController
public class TyController {

    @Autowired
    private TyService tyService;

    // http://localhost:8081/mock/test
    @GetMapping("/test")
    @ResponseBody
    public List<String> test() {
        List<String> strings = tyService.find();
        return strings;

    }


}
