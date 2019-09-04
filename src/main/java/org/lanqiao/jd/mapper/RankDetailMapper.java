package org.lanqiao.jd.mapper;

import org.lanqiao.jd.entity.RankDetail;

import java.util.List;

public interface RankDetailMapper {

    List<RankDetail> selectDetail(Integer rankId);

    int deleteByPrimaryKey(Integer rankDetailId);

    int insert(RankDetail record);

    int insertSelective(RankDetail record);

    RankDetail selectByPrimaryKey(Integer rankDetailId);

    int updateByPrimaryKeySelective(RankDetail record);

    int updateByPrimaryKey(RankDetail record);
}