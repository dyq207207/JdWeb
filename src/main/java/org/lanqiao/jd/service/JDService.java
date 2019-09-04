package org.lanqiao.jd.service;

import org.lanqiao.jd.entity.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface JDService {
    public List<Order> getAllOrder(Integer user_id, String order_status, Integer pageNum, Integer pageSize, String search_text);
    public int deleteOrder(Integer order_id);
    public int deleteOrderItem(Integer order_id);

    public int calcPageCount(int pageSize, int user_id, String order_status, String search_text);

    public int getOrderCount(int user_id, String order_status);
}
