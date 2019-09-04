package org.lanqiao.jd.mapper;

import org.lanqiao.jd.entity.Image;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageMapper {
    int deleteByPrimaryKey(Integer imgId);

    int insert(Image record);

    int insertSelective(Image record);

    Image selectByPrimaryKey(Integer imgId);

    int updateByPrimaryKeySelective(Image record);

    int updateByPrimaryKey(Image record);
    List<Image> getAllimage(Integer goodid);
}