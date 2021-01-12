package com.project.software2020.service;

import com.project.software2020.mapper.UserMapper;
import com.project.software2020.pojo.ReturnMessage;
import com.project.software2020.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    ReturnMessage register(User user);
    ReturnMessage login(User user);

    ReturnMessage getUserBalanceByUserId(String user_id);

}
