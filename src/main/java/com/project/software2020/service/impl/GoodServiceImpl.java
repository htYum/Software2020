package com.project.software2020.service.impl;

import com.project.software2020.mapper.GoodMapper;
import com.project.software2020.mapper.ImgMapper;
import com.project.software2020.mapper.UserMapper;
import com.project.software2020.pojo.*;
import com.project.software2020.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;

@Service
@Transactional(rollbackFor = RuntimeException.class)
public class GoodServiceImpl implements GoodService {

    @Autowired
    private GoodMapper goodMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ImgMapper imgMapper;

    @Override
    public ReturnMessage getGoodsByUserId(String user_id){
        ReturnMessage result = new ReturnMessage();
        result.setCode(0);
        result.setData(null);

        List<GoodInfo> goods;
        try {
            goods = goodMapper.getGoodsByUserId(user_id);
            result.setCode(1);
            result.setMessage("获取成功");
            result.setData(goods);
            return result;
        }
        catch (Exception e){
            result.setCode(0);
            result.setMessage(e.getMessage());
            result.setData(null);
            return result;
        }
    }

    @Override
    public ReturnMessage getGoodsByGoodName(String good_name) {
        ReturnMessage result = new ReturnMessage();
        result.setCode(0);
        result.setData(null);

        List<GoodInfo> goods;

        try {
            goods = goodMapper.getGoodsByGoodName(good_name);
            result.setCode(1);
            result.setMessage("获取成功");
            result.setData(goods);
            return result;
        }
        catch (Exception e){
            result.setCode(0);
            result.setMessage(e.getMessage());
            result.setData(null);
            return result;
        }
    }

    @Override
    public ReturnMessage releaseGood(GoodInfo goodInfo){
        ReturnMessage result = new ReturnMessage();
        result.setCode(0);
        result.setData(null);

        try {
            goodMapper.releaseGood(goodInfo);
            result.setCode(1);
            result.setMessage("发布成功");
            result.setData(goodMapper.getGoodByGoodId(goodInfo.getGood_id()));
            return result;
        }
        catch (Exception e){
            result.setCode(0);
            result.setMessage(e.getMessage());
            result.setData(null);
            return result;
        }
    }

    @Override
    public ReturnMessage deleteGoodByGoodId(int good_id){
        ReturnMessage result = new ReturnMessage();
        result.setCode(0);
        result.setData(null);

        try {
            goodMapper.deleteGoodByGoodId(good_id);
            result.setCode(1);
            result.setMessage("删除成功");
            result.setData(null);
            return result;
        }
        catch (Exception e){
            result.setCode(0);
            result.setMessage(e.getMessage());
            result.setData(null);
            return result;
        }
    }

    @Override
    public ReturnMessage getShoppingGoodsByUserId(String user_id){
        ReturnMessage result = new ReturnMessage();
        result.setCode(0);
        result.setData(null);

        List<Integer> goodIds;
        List<GoodInfo> goods = new LinkedList<>();

        try {
            goodIds = goodMapper.getShoppingGoodIdsByUserId(user_id);
            result.setCode(1);
            result.setMessage("获取成功");
            for(int i = 0; i < goodIds.size(); i++){
                goods.add(goodMapper.getGoodByGoodId(goodIds.get(i).intValue()));
            }
            result.setData(goods);
            return result;
        }
        catch (Exception e){
            result.setCode(1);
            result.setMessage(e.getMessage());
            result.setData(null);
            return result;
        }
    }

    @Override
    public ReturnMessage deleteShoppingGoodByUserIdAndGoodId(ShoppingCart shoppingCart){
        ReturnMessage result = new ReturnMessage();
        result.setCode(0);
        result.setData(null);

        try {
            goodMapper.deleteShoppingGoodsByUserIdAndGoodId(shoppingCart);
            result.setCode(1);
            result.setMessage("删除成功");
            result.setData(null);
            return result;
        }
        catch (Exception e){
            result.setCode(0);
            result.setMessage(e.getMessage());
            result.setData(null);
            return result;
        }
    }

    @Override
    public ReturnMessage getSoldGoodsByUserId(String user_id){
        ReturnMessage result = new ReturnMessage();
        result.setCode(0);
        result.setData(null);

        try{
            List<GoodInfo> goods = goodMapper.getSoldGoodsByUserId(user_id);
            result.setCode(1);
            result.setMessage("返回成功");
            result.setData(goods);
            return result;
        }
        catch (Exception e){
            result.setCode(0);
            result.setMessage(e.getMessage());
            result.setData(null);
            return result;
        }
    }

    @Override
    public ReturnMessage insertShoppingCart(ShoppingCart shopping){
        ReturnMessage result = new ReturnMessage();
        result.setCode(0);
        result.setData(null);

        try {
            goodMapper.insertShoppingCart(shopping);
            result.setCode(1);
            result.setMessage("添加成功");
            result.setData(shopping);
            return result;
        }
        catch (Exception e){
            result.setCode(0);
            result.setMessage(e.getMessage());
            result.setData(null);
            return result;
        }
    }

    @Override
    public ReturnMessage getAllGoods(){
        ReturnMessage result = new ReturnMessage();
        result.setCode(0);
        result.setData(null);

        try {
            List<GoodInfoWithImgPath> goods = goodMapper.getAllGoods();

            // 获取商品图片
            for(int i = 0; i < goods.size(); i++){
                GoodInfoWithImgPath good = goods.get(i);
                int good_id = good.getGood_id();
                ImgInfo imgInfo = imgMapper.getMainGoodImgByGoodId(good_id);
                String imgPath = imgInfo.getRelative_url() + imgInfo.getImg_name();
                good.setImg_path(imgPath);
            }
            result.setCode(1);
            result.setMessage("获取成功");
            result.setData(goods);
            return result;
        }
        catch (Exception e){
            result.setCode(0);
            result.setMessage(e.getMessage());
            result.setData(null);
            return result;
        }
    }

    @Override
    public ReturnMessage deal(SellLog sellLog){
        ReturnMessage result = new ReturnMessage();
        result.setCode(0);
        result.setData(null);

        try {
            String buyer_id = sellLog.getBuyer_id();
            String seller_id = sellLog.getSeller_id();
            int good_id = sellLog.getGood_id();
            float buyer_balance = userMapper.getBalanceByUserId(buyer_id);
            GoodInfo good = goodMapper.getGoodByGoodId(good_id);
            float price = good.getPrice();

            // 买卖家相同
            if(buyer_id == seller_id){
                result.setCode(0);
                result.setMessage("不能购买自己发布的商品");
                result.setData(null);
                return result;
            }
            // 余额不足
            if(buyer_balance < price){
                result.setCode(0);
                result.setMessage("余额不足");
                result.setData(null);
                return result;
            }

            // 余额足够，进行交易
            userMapper.updateBalanceByUserid(buyer_id,price * (-1));
            userMapper.updateBalanceByUserid(seller_id, price);
            goodMapper.updateGoodToSold(good_id);
            goodMapper.insertSellLog(sellLog);

            // 从所有购物车中删除该商品
            goodMapper.deleteAllShoppingGoodsByGoodId(good_id);

            result.setCode(1);
            result.setMessage("交易成功");
            result.setData(sellLog);
            return result;
        }
        catch (Exception e){
            result.setCode(0);
            result.setMessage(e.getMessage());
            result.setData(null);
            return result;
        }
    }

    @Override
    public ReturnMessage getGoodByGoodId(int good_id){
        ReturnMessage result = new ReturnMessage();
        result.setCode(0);
        result.setData(null);

        try {
            GoodInfo good = goodMapper.getGoodByGoodId(good_id);
            result.setCode(1);
            result.setMessage("获取成功");
            result.setData(good);
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
