package org.lanqiao.jd.mapper;

import org.lanqiao.jd.entity.Order;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderMapper {
    int deleteByPrimaryKey(Integer order_id);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Integer order_id);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);
}