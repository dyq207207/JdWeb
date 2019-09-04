package org.lanqiao.jd.mapper;

import org.lanqiao.jd.entity.Cart;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartMapper {
    int deleteCartGoods(Integer userId, Integer goodsId);

    int insert(Cart record);

    int insertSelective(Cart record);

    List<Cart> selectCartGoods(Integer userId);

    Cart selectByPrimaryKey(Integer cart_id);

    int changeGoodsNum(Integer goodsNum, Integer userId, Integer goodsId);

    int updateByPrimaryKeySelective(Cart record);

    int updateByPrimaryKey(Cart record);

    int update(Cart record);

}