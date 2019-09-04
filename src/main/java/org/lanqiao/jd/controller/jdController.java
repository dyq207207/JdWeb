package org.lanqiao.jd.controller;

import org.lanqiao.jd.entity.Order;
import org.lanqiao.jd.service.JDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class jdController {
    @Autowired
    JDService jdService;

    @RequestMapping("/getOrder1")
    public Map getAllOrder(Integer user_id,String order_status,Integer pageNum,Integer pageSize,String search_text){
         List<Order> orderList=jdService.getAllOrder(user_id,order_status,pageNum,pageSize,search_text);
         int pageCount = jdService.calcPageCount(pageSize,user_id,order_status,search_text);
        Map map=new HashMap();
        map.put("pageCount",pageCount);
        map.put("orderList",orderList);
        return map;
    }

    @RequestMapping("/deleteOrder")
    public int deleteOrder(Integer order_id){
        return jdService.deleteOrder(order_id);
    }

    @RequestMapping("/deleteOrderItem")
    public int deleteOrderItem(Integer order_id){
        return jdService.deleteOrderItem(order_id);
    }

    @RequestMapping("/getOrderCount")
    public int getOrderCount(int user_id,String order_status){
        return jdService.getOrderCount(user_id,order_status);
    }


}
