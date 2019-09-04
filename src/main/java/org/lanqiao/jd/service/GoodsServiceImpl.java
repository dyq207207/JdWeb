package org.lanqiao.jd.service;

import org.lanqiao.jd.entity.*;
import org.lanqiao.jd.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService{
    @Autowired
    SecondSortMapper secondSortMapper;


    @Override
    public List<SecondSort> getSsSort(Integer goodid) {
        return secondSortMapper.getSsSort(goodid);
    }

    @Autowired
    ImageMapper imageMapper;
    @Override
    public List<Image> getAllimage(Integer goodid) {
        return imageMapper.getAllimage(goodid);
    }
    @Autowired
    FirstSortMapper firstSortMapper;

    @Override
    public List<FirstSort> getFsSort(Integer goodid) {
        return firstSortMapper.getFsSort(goodid);
    }
    @Autowired
    CartMapper cartMapper;
    @Override
    public int insert(Cart record) {
        return cartMapper.insert(record);
    }

    @Override
    public int update(Cart record) {
        return cartMapper.update(record);
    }
    @Autowired
    GoodsMapper goodsMapper;
    @Override
    public List<Goods> getAllgoods(int goodid) {
        return goodsMapper.getAllgoods(goodid);
    }

    @Override
    public int getGoodsId(String goods_name) {
        return goodsMapper.getGoodsId(goods_name);
    }
}
