package com.project.software2020.mapper;

import com.project.software2020.pojo.*;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

@Mapper
@Repository
public interface GoodMapper {

    /**
     * 发布商品
     * @param goodInfo
     */
    @Insert("insert into good_info (" +
            "good_name," +
            "user_id," +
            "price," +
            "description," +
            "category) values (" +
            "#{good_name}," +
            "#{user_id}," +
            "#{price}," +
            "#{description}," +
            "#{category})")
    @Options(useGeneratedKeys = true, keyProperty = "good_id")
    void releaseGood(GoodInfo goodInfo);

    /**
     * 按good_id获取商品
     * @param good_id
     * @return
     */
    @Select("select * from good_info m where " +
            "m.good_id=#{good_id} and m.is_sold=0")
    GoodInfo getGoodByGoodId(int good_id);

    /**
     * 获取某用户发布的商品列表
     * @param user_id
     * @return
     */
    @Select("select * from good_info m where " +
            "m.user_id=#{user_id} " +
            "order by modified_time desc")
    List<GoodInfo> getGoodsByUserId(String user_id);

    /**
     * 按名称模糊搜索商品
     * @param good_name
     * @return
     */
    @Select("select * from good_info m where " +
            "m.good_name like '%${good_name}%' and is_sold=0")
    List<GoodInfo> getGoodsByGoodName(String good_name);

    /**
     * 按good_id删除商品
     * @param good_id
     */
    @Delete("delete from good_info where " +
            "good_id=#{good_id}")
    void deleteGoodByGoodId(int good_id);

    /**
     * 按user_id在购物车搜索出good_id列表
     * @param user_id
     * @return
     */
    @Select("select good_id from shopping_cart where " +
            "user_id=#{user_id}")
    List<Integer> getShoppingGoodIdsByUserId(String user_id);

    /**
     * 添加购物车
     * @param shopping
     */
    @Insert("insert into shopping_cart (user_id,good_id) values (#{user_id},#{good_id})")
    void insertShoppingCart(ShoppingCart shopping);

    /**
     * 按user_id和good_id删除购物车内某件商品
     * @param shoppingCart
     */
    @Delete("delete from shopping_cart where " +
            "user_id=#{user_id} and good_id=#{good_id}")
    void deleteShoppingGoodsByUserIdAndGoodId(ShoppingCart shoppingCart);

    /**
     * 按user_id查找已出售商品
     * @param user_id
     * @return
     */
    @Select("select * from good_info where " +
            "user_id=#{user_id} and is_sold=1")
    List<GoodInfo> getSoldGoodsByUserId(String user_id);

    /**
     **获取全部未售出商品
     * @return
     */
    @Select("select * from good_info where is_sold=0")
    List<GoodInfoWithImgPath> getAllGoods();

    /**
     * 向SellLog添加记录
     * @param sellLog
     */
    @Insert("insert into sell_log (buyer_id,seller_id,good_id) " +
            "values(" +
            "#{buyer_id}," +
            "#{seller_id}," +
            "#{good_id})")
    @Options(useGeneratedKeys = true, keyProperty = "log_id")
    void insertSellLog(SellLog sellLog);

    /**
     * 按good_id将物品改为已出售
     * @param good_id
     */
    @Update("update good_info set is_sold=1 where good_id=#{good_id}")
    void updateGoodToSold(int good_id);

    /**
     * 按good_id从所有购物车中删除此商品
     * @param good_id
     */
    @Delete("delete from shopping_cart where good_id=#{good_id}")
    void deleteAllShoppingGoodsByGoodId(int good_id);
}
