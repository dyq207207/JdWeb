package org.lanqiao.jd.controller;

import org.lanqiao.jd.entity.Brand;
import org.lanqiao.jd.entity.Goods;
import org.lanqiao.jd.entity.Rank;
import org.lanqiao.jd.entity.RankDetail;
import org.lanqiao.jd.service.SearchService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class serachController {
    @Autowired
    SearchService searchService;

    @RequestMapping("/fuzzySearch")
    public List<Goods> fuzzySearch(String name) {
        List<Goods> l = searchService.fuzzySearch(name);
        return searchService.fuzzySearch(name);
    }

    @RequestMapping("/orderBy")
    public List<Goods> orderBy(String name,Integer orderByState) {
        return searchService.orderBy(name,orderByState);
    }

    @RequestMapping("/priceInterval")
    public List<Goods> priceInterval(String name, Double lowPrice, Double highPrice) {
        return searchService.priceInterval(name,lowPrice,highPrice);
    }

    @RequestMapping("/brandSearch")
    public List<Goods> brandSearch(String name,String brandName) {
        return searchService.brandSearch(name,brandName);
    }
    @RequestMapping("/insertBrand")
    public List<Brand> insertBrand(String name) {
        List<Brand> brands=searchService.insertBrand(name);
        return searchService.insertBrand(name);
    }

    @RequestMapping("/selectRank")
    public List<Rank> selelctRank(String name){
        return searchService.selelctRank(name);
    }

    @RequestMapping("/selectDetail")
    public List<RankDetail> sellectDetail(String name, Integer index) {
        return searchService.sellectDetail(name,index);
    }
}
