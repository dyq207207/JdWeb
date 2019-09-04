package org.lanqiao.jd.service;

import org.lanqiao.jd.entity.Cart;
import org.lanqiao.jd.entity.Order;
import org.lanqiao.jd.entity.OrderItem;

import java.util.List;

public interface CartService {
    public List<Cart> selectCartGoods(Integer userId);
    public int changeGoodsNum(Integer goodsNum, Integer userId, Integer goodsId);
    public int deleteCartGoods(Integer userId, Integer goodsId);
    public int createOrder(List<OrderItem> orderItems, Order order);
    public List<Object> selectRegion(Integer userId);
}
