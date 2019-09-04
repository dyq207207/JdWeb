package org.lanqiao.jd.mapper;

import org.lanqiao.jd.entity.Order;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface JDMapper {

    //根据条件查询订单
    public List<Order> getAllOrder1(Map map);

    //根据订单id删除订单表和订单详情表中内容
    public int deleteOrderItem(Integer oreder_id);

    //获取数据总条数
    public int getOrderCount(Map map);





}