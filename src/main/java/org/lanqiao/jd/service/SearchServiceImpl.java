package org.lanqiao.jd.service;

import org.lanqiao.jd.entity.*;
import org.lanqiao.jd.entity.Brand;
import org.lanqiao.jd.entity.Goods;
import org.lanqiao.jd.entity.Rank;
import org.lanqiao.jd.entity.RankDetail;
import org.lanqiao.jd.mapper.ClassfyMapper;
import org.lanqiao.jd.mapper.GoodsMapper;
import org.lanqiao.jd.mapper.RankMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchServiceImpl implements SearchService {
    @Autowired
    GoodsMapper goodsMapper;
    @Autowired
    ClassfyMapper classfyMapper;

    @Autowired
    RankMapper rankMapper;

    @Override
    public List<Goods> fuzzySearch(String name) {
        if (name.equals("")){
            name = null;
        }
        String secName = getSecName(name);

        if ("write error".equals(secName)){
            return null;
        }else{
            return goodsMapper.fuzzySearch(secName);
        }
    }

    @Override
    public List<Goods> orderBy(String name,Integer orderByState) {
        String secName = getSecName(name);
        if ("write error".equals(secName)){
            return null;
        }else {
            return goodsMapper.orderBy(secName, orderByState);
        }
    }

    @Override
    public List<Goods> priceInterval(String name, Double lowPrice, Double highPrice) {
        String secName = getSecName(name);
        if ("write error".equals(secName)){
            return null;
        }else {
            return goodsMapper.priceInterval(name, lowPrice, highPrice);
        }
    }

    @Override
    public List<Goods> brandSearch(String name,String brandName) {
        String secName = getSecName(name);
        if ("write error".equals(secName)){
            return null;
        }else {
//        String str = brandName.substring(28);
            String str = brandName.substring(22);
            return goodsMapper.brandSearch(name, str);
        }
    }

    @Override
    public List<Brand> insertBrand(String name) {
        List<Goods> goods = goodsMapper.insertBrand(name);
        List<Brand> brands = new ArrayList<Brand>();
        for (int i = 0; i < goods.size(); i++) {
            brands.add(goods.get(i).getBrand());
        }
        return brands;
    }

    @Override
    public List<Rank> selelctRank(String name) {
        return classfyMapper.selelctRank(name);
    }

    @Override
    public List<RankDetail> sellectDetail(String name, Integer index) {
        List<RankDetail> details = new ArrayList<RankDetail>();
        try {
            List<Rank> ranks = classfyMapper.selelctRank(name);
            details = rankMapper.sellectDetail(ranks.get(index-1).getRankName());
        }catch (Exception e){
            e.printStackTrace();
        }
        return details;
    }

    //自定义方法
    private String getSecName(String name){
        int flag = 0;
        int len1 = 0,len2 = 0;
        try {
            List<String> strArr1 = getArrName(name);
            List<String> strArr2 = classfyMapper.getName();
            for (String s:strArr2) {
                System.out.println(s);
            }
            len1 = strArr1.size();
            len2 = strArr2.size();
            for (int i=0;i < len1 ;i++){
                for (int j=0; j <len2 ;j++){
                    flag = strArr1.get(i).indexOf(strArr2.get(j));
                    if (flag != -1){
                        return strArr2.get(j);
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return "write error";
    }
    private List<String> getArrName(String name){
        int flag = 0;
        List<String> str = new ArrayList<String>();
        if (goodsMapper != null){
            for (String temp:goodsMapper.getAllGoodsName()) {
                flag = temp.indexOf(name);
                if (flag != -1){
                    str.add(temp);
                }
            }
        }
        return str;
    }
}
