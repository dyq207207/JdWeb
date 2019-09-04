package org.lanqiao.jd.controller;

import org.lanqiao.jd.entity.Cart;
import org.lanqiao.jd.entity.Order;
import org.lanqiao.jd.entity.OrderItem;
import org.lanqiao.jd.entity.OrderVo;
import org.lanqiao.jd.service.CartService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@MapperScan("org/lanqiao/jd/mapper")
@EnableTransactionManagement
public class CartController {
    @Autowired
    CartService cartService;
    @RequestMapping("/selectCartGoods")
    public List<Cart> selectCartGoods(Integer userId){
        return cartService.selectCartGoods(userId);
    }
    @RequestMapping("/deleteCartName")
    public int deleteCartName(Integer userId, Integer goodsId){
        return cartService.deleteCartGoods(userId,goodsId);
    }
    @RequestMapping("/changeGoodsNum")
    public int changeGoodsNum(Integer goodsNum,Integer userId, Integer goodsId ){
        return cartService.changeGoodsNum(goodsNum,userId,goodsId);
    }
    @RequestMapping("/createOrder")
    public int createOrder(@RequestBody OrderVo orderVo){
        Order order = orderVo.getOrder();
        List<OrderItem> orderItems = orderVo.getOrderItems();
        return cartService.createOrder(orderItems,order);
    }
    @RequestMapping("/address")
    public List<Object> selectRegion(Integer userId){
        return cartService.selectRegion(userId);
    }
}
