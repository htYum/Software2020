package com.project.software2020.service;

import com.project.software2020.pojo.GoodInfo;
import com.project.software2020.pojo.ReturnMessage;
import com.project.software2020.pojo.SellLog;
import com.project.software2020.pojo.ShoppingCart;
import org.springframework.stereotype.Service;

@Service
public interface GoodService {
    ReturnMessage getGoodsByUserId(String user_id);
    ReturnMessage getGoodsByGoodName(String good_name);
    ReturnMessage getGoodByGoodId(int good_id);

    ReturnMessage releaseGood(GoodInfo goodInfo);

    ReturnMessage deleteGoodByGoodId(int good_id);

    ReturnMessage getShoppingGoodsByUserId(String user_id);

    ReturnMessage deleteShoppingGoodByUserIdAndGoodId(ShoppingCart shoppingCart);

    ReturnMessage getSoldGoodsByUserId(String user_id);

    ReturnMessage insertShoppingCart(ShoppingCart shopping);

    ReturnMessage getAllGoods();

    ReturnMessage deal(SellLog sellLog);
}
