package org.lanqiao.jd.mapper;

import org.lanqiao.jd.entity.Region;
import org.springframework.stereotype.Repository;

@Repository
public interface RegionMapper {
    int deleteByPrimaryKey(Integer regionId);

    int insert(Region record);

    int insertSelective(Region record);

    Region selectByPrimaryKey(Integer regionId);

    String select(Integer regionId);

    int updateByPrimaryKeySelective(Region record);

    int updateByPrimaryKey(Region record);
}