package org.lanqiao.jd.mapper;

import org.lanqiao.jd.entity.Goods;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodsMapper {
    int deleteByPrimaryKey(Integer goodsId);

    int insert(Goods record);

    int insertSelective(Goods record);

    Goods selectByPrimaryKey(Integer goodsId);

    int selectGoodsId(String goodsName);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);

    List<Goods> getAllgoods (int goodid);

    List<String> getAllGoodsName();

    int getGoodsId(String goods_name);

    List<Goods> fuzzySearch(String name);
    List<Goods> orderBy(String name,Integer orderByState);
    List<Goods> priceInterval(String name,Double lowPrice,Double highPrice);
    List<Goods> brandSearch(String name,String brandName);
    List<Goods> insertBrand(String name);
}