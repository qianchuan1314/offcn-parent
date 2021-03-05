package com.offcn.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "ripe对项目模块的测试")
@RequestMapping("ripe")
@RestController
public class RipeController {
    @ApiOperation(value = "一个简单的小测试")
    @ApiImplicitParam(value = "姓名",name="name",required = true)
    @GetMapping("/name")
    public String ripe(String name){
        return name;
    }
}
