package org.lanqiao.jd.mapper;

import org.lanqiao.jd.entity.FirstSort;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FirstSortMapper {
    int deleteByPrimaryKey(Integer first_sort_id);

    int insert(FirstSort record);

    int insertSelective(FirstSort record);

    FirstSort selectByPrimaryKey(Integer first_sort_id);

    int updateByPrimaryKeySelective(FirstSort record);

    int updateByPrimaryKey(FirstSort record);

    List<FirstSort> getFsSort(Integer goodid);
}