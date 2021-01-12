package com.project.software2020.controller;

import com.project.software2020.pojo.GoodInfo;
import com.project.software2020.pojo.ReturnMessage;
import com.project.software2020.pojo.SellLog;
import com.project.software2020.pojo.ShoppingCart;
import com.project.software2020.service.impl.GoodServiceImpl;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.PreparedStatement;

@RestController
@RequestMapping("/good")
public class GoodController {
    @Autowired
    private GoodServiceImpl goodService;

    /**
     * 按user_id获取该用户所有商品
     * @param user_id
     * @return
     */
    @GetMapping("/userid/{user_id}")
    public ReturnMessage getGoodsByUserId(@PathVariable("user_id")String user_id){
        return goodService.getGoodsByUserId(user_id);
    }

    /**
     * 按good_name模糊搜索商品
     * @param good_name
     * @return
     */
    @GetMapping("/goodname/{good_name}")
    public ReturnMessage getGoodsByGoodName(@PathVariable("good_name")String good_name){
        return goodService.getGoodsByGoodName(good_name);
    }

    /**
     * 发布商品
     * @param goodInfo
     * @return
     */
    @PostMapping("/releasegood")
    public ReturnMessage releaseGood(@RequestBody GoodInfo goodInfo){
        return goodService.releaseGood(goodInfo);
    }

    /**
     * 按good_id删除商品
     * @param good_id
     * @return
     */
    @DeleteMapping("/goodid/{good_id}")
    public ReturnMessage deleteGoodByGoodId(@PathVariable("good_id")int good_id){
        return goodService.deleteGoodByGoodId(good_id);
    }

    /**
     * 按user_id获取用户购物车商品列表（没有添加时间）
     * @param user_id
     * @return
     */
    @GetMapping("/shopping/{user_id}")
    public ReturnMessage getShoppingGoodsByUserId(@PathVariable("user_id")String user_id){
        return goodService.getShoppingGoodsByUserId(user_id);
    }

    /**
     * 按user_id和good_id删除购物车内某件物品
     * @param shoppingCart
     * @return
     */
    @DeleteMapping("/shopping")
    public ReturnMessage deleteShoppingGoodByUserIdAndGoodId(@RequestBody ShoppingCart shoppingCart){
        return goodService.deleteShoppingGoodByUserIdAndGoodId(shoppingCart);
    }

    /**
     * 按user_id获取用户出售物品列表
     * @param user_id
     * @return
     */
    @GetMapping("/sold/{user_id}")
    public ReturnMessage getSoldGoodsByUserId(@PathVariable("user_id")String user_id){
        return goodService.getSoldGoodsByUserId(user_id);
    }

    /**
     * 添加购物车
     * @param shopping
     * @return
     */
    @PostMapping("/addshopping")
    public ReturnMessage insertShoppingCart(@RequestBody ShoppingCart shopping){
        return goodService.insertShoppingCart(shopping);
    }

    /**
     * 获取所有未出售商品
     * @return
     */
    @GetMapping("/all")
    public ReturnMessage getAllGoods(){
        return goodService.getAllGoods();
    }

    /**
     * 交易
     * @param sellLog
     * @return
     */
    @PostMapping("/deal")
    public ReturnMessage deal(@RequestBody SellLog sellLog){
        return goodService.deal(sellLog);
    }

    @GetMapping("/{good_id}")
    public ReturnMessage getGoodByGoodId(@PathVariable("good_id")int good_id){
        return goodService.getGoodByGoodId(good_id);
    }
}
