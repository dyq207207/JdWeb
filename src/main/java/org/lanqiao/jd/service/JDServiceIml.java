package org.lanqiao.jd.service;

import org.lanqiao.jd.entity.Order;
import org.lanqiao.jd.mapper.JDMapper;
import org.lanqiao.jd.mapper.OrderMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class JDServiceIml implements JDService {

    @Autowired
    JDMapper jdMapper;

    @Autowired
    OrderMapper ordMapper;


    @Override
    public List<Order> getAllOrder(Integer user_id, String order_status, Integer pageNum, Integer pageSize, String search_text)   {
        int startNum = (pageNum-1)*pageSize;
        Map map= new HashMap();
        map.put("user_id",user_id);
        map.put("order_status",order_status);
        map.put("startNum",startNum);
        map.put("pageSize",pageSize);
        map.put("search_text",search_text);
        return jdMapper.getAllOrder1(map);
    }

    public int deleteOrder(Integer order_id){
        return ordMapper.deleteByPrimaryKey(order_id);
    }

    public int deleteOrderItem(Integer order_id){
        return  jdMapper.deleteOrderItem(order_id);
    }


    @Override
    public int calcPageCount(int pageSize,int user_id,String order_status,String search_text){
        Map map = new HashMap();
        map.put("user_id",user_id);
        map.put("order_status",order_status);
        map.put("search_text",search_text);
        int rowCount = jdMapper.getOrderCount(map);
        if(rowCount%pageSize==0){
            return rowCount/pageSize;
        }else
            return rowCount/pageSize+1;
    }


    @Override
    public int getOrderCount(int user_id,String order_status){
        Map map= new HashMap();
        map.put("user_id",user_id);
        map.put("order_status",order_status);
        return jdMapper.getOrderCount(map);
    }



}
