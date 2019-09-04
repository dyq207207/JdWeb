package org.lanqiao.jd.mapper;


import org.lanqiao.jd.entity.Rank;
import org.lanqiao.jd.entity.RankDetail;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RankMapper {

    List<RankDetail> sellectDetail(String rankName);

    int deleteByPrimaryKey(Integer rankId);

    int insert(Rank record);

    int insertSelective(Rank record);

    Rank selectByPrimaryKey(Integer rankId);

    int updateByPrimaryKeySelective(Rank record);

    int updateByPrimaryKey(Rank record);
}