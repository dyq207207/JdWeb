package org.lanqiao.jd.mapper;

import org.lanqiao.jd.entity.SecondSort;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SecondSortMapper {
    int deleteByPrimaryKey(Integer two_sort_id);

    int insert(SecondSort record);

    int insertSelective(SecondSort record);

    SecondSort selectByPrimaryKey(Integer two_sort_id);

    int updateByPrimaryKeySelective(SecondSort record);

    int updateByPrimaryKey(SecondSort record);

    List<SecondSort> getSsSort(Integer goodid);
}