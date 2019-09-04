package org.lanqiao.jd.service;

import org.lanqiao.jd.entity.Brand;
import org.lanqiao.jd.entity.Goods;
import org.lanqiao.jd.entity.Rank;
import org.lanqiao.jd.entity.RankDetail;

import java.util.List;

public interface SearchService {

    List<Goods> fuzzySearch(String name);
    List<Goods> orderBy(String name, Integer orderByState);
    List<Goods> priceInterval(String name, Double lowPrice, Double highPrice);
    List<Goods> brandSearch(String name, String brandName);
    List<Brand> insertBrand(String name);
    List<Rank> selelctRank(String name);
    List<RankDetail> sellectDetail(String name, Integer index);
}
