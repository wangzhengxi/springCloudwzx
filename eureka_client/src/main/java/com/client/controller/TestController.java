package com.client.controller;

import com.client.Model.TestEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * Created by wangzhengxi on 2019/6/10.
 */
@RestController
@RequestMapping(value = "test")
@CrossOrigin
@Validated
public class TestController {


    @PostMapping
    public String testAa(@Validated   TestEntity testEntity){

        int a=1;
        return a+"aaa"+testEntity.getAge()+testEntity.getName();

    }



}
