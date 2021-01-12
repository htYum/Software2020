package com.project.software2020.mapper;

import com.project.software2020.pojo.User;
import com.project.software2020.pojo.UserBalance;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    @Select("select user_id,password from user_login u where u.user_id=#{user_id}")
    @Results({@Result(property = "user_id", column = "user_id"),
            @Result(property = "password", column = "password")})
    User findUserById(@Param("user_id") String user_id);

    /**
     * 注册
     * @param user
     * @return
     */
    @Insert("insert into user_login (user_id,user_name,password,phone,major,school) " +
            "values(" +
            "#{user_id}," +
            "#{user_id}," +
            "#{password}," +
            "#{phone}," +
            "#{major}," +
            "#{school})")
    void register(User user);

    /**
     * 登录
     * @param user
     * @return
     */
    @Select("select * from user_login where user_id=#{user_id} and password=#{password}")
    User login(User user);

    /**
     * 按user_id获取用户余额相关信息
     * @param user_id
     * @return
     */
    @Select("select user_id,balance,modified_time from user_login where " +
            "user_id=#{user_id}")
    UserBalance getUserBalanceByUserId(String user_id);

    /**
     * 获取用户余额
     * @param user_id
     * @return
     */
    @Select("select balance from user_login where user_id=#{user_id}")
    float getBalanceByUserId(String user_id);

    /**
     * 获取具体余额
     * @param user_id
     * @param balance
     */
    @Update("update user_login set balance=#{balance}+balance where user_id=#{user_id}")
    void updateBalanceByUserid(String user_id, float balance);
}

