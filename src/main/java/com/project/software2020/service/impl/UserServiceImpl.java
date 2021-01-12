package com.project.software2020.service.impl;

import com.project.software2020.mapper.UserMapper;
import com.project.software2020.pojo.ReturnMessage;
import com.project.software2020.pojo.User;
import com.project.software2020.pojo.UserBalance;
import com.project.software2020.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = RuntimeException.class)
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    /**
     * 注册
     * @param user
     * @return ReturnMessage
     */
    @Override
    public ReturnMessage register(User user){
        ReturnMessage result = new ReturnMessage();
        result.setCode(0);
        result.setData(null);
        try{
            User existedUser = userMapper.findUserById(user.getUser_id());
            if(existedUser != null){
                result.setMessage("用户已存在");
            }
            else{
                userMapper.register(user);
                result.setMessage("注册成功");
                result.setCode(1);
                result.setData(null);
            }
        }
        catch (Exception e){
            result.setMessage(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 登录
     * @param user
     * @return
     */
    @Override
    public ReturnMessage login(User user){
        ReturnMessage result = new ReturnMessage();
        result.setCode(0);
        result.setData(null);
        try{
            User login_user = userMapper.login(user);
            if(login_user == null){
                result.setMessage("用户名或密码错误");
            }
            else{
                result.setCode(1);
                result.setData(login_user);
                result.setMessage("登录成功");
            }
        }
        catch (Exception e){
            result.setMessage(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public ReturnMessage getUserBalanceByUserId(String user_id){
        ReturnMessage result = new ReturnMessage();
        result.setCode(0);
        result.setData(null);

        try{
            UserBalance balance = userMapper.getUserBalanceByUserId(user_id);
            result.setCode(1);
            result.setMessage("返回成功");
            result.setData(balance);
            return result;
        }
        catch (Exception e){
            result.setCode(0);
            result.setMessage(e.getMessage());
            result.setData(null);
            return result;
        }
    }
}
