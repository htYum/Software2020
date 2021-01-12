package com.project.software2020.controller;

import com.project.software2020.pojo.ReturnMessage;
import com.project.software2020.pojo.User;
import com.project.software2020.service.impl.UserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Api(tags = "用户操作接口")
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    /**
     * 注册
     * @param user 注册用户的参数
     * @return ReturnMessage
     */
    @ApiOperation("注册")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user_id", value = "用户id"),
            @ApiImplicitParam(name = "user_name", value = "用户名"),
            @ApiImplicitParam(name = "password", value = "密码"),
            @ApiImplicitParam(name = "phone", value = "手机号"),
            @ApiImplicitParam(name = "balance", value = "用户余额"),
            @ApiImplicitParam(name = "major", value = "专业"),
            @ApiImplicitParam(name = "school", value = "学院"),
            @ApiImplicitParam(name = "modified_time", value = "修改时间", defaultValue = "CURRENT_TIME")
    })
    @PostMapping(value = "/register")
    public ReturnMessage register(@RequestBody User user){
        return userService.register(user);
    }

    /**
     * 登录
     * @param user
     * @return
     */
    @PostMapping("/login")
    @ApiOperation("登录")
    public ReturnMessage login(@RequestBody User user){
        return userService.login(user);
    }

    /**
     * 按user_id查询用户余额
     * @param user_id
     * @return
     */
    @GetMapping("/balance/{user_id}")
    @ApiOperation("查询用户余额")
    public ReturnMessage getUserBalanceByUserId(@PathVariable("user_id")String user_id){
        return userService.getUserBalanceByUserId(user_id);
    }

}
