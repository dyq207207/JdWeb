package org.lanqiao.jd.mapper;

import org.lanqiao.jd.entity.Address;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressMapper {
    int deleteByPrimaryKey(Integer addressId);

    int insert(Address record);

    int insertSelective(Address record);

    Address selectByPrimaryKey(Integer addressId);

    Address selectAddr(Integer userId);

    int updateByPrimaryKeySelective(Address record);

    int updateByPrimaryKey(Address record);
}