package com.offcn.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = {"ripe自己的controller测试"})
@RequestMapping("/test")
public class RipeController {
    @ApiImplicitParam(name = "name",value = "姓名",required = true )
    @GetMapping("/ripe")
    public String ripeTest(String name){
        return name+"  ripe";
    }
}
