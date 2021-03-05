package com.offcn.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "第一个swagger测试")
@RestController
public class HelloController {
    @ApiOperation("hello测试方法")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name="name",value = "姓名",required = true),
            @ApiImplicitParam(name="age",value = "年龄")
    })
    @GetMapping("/hello")
    public String hello(String name){
        return "hello"+name;
    }

}
