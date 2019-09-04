package org.lanqiao.jd.service;

import org.lanqiao.jd.entity.*;

import java.util.List;

public interface GoodsService {
    List<SecondSort> getSsSort(Integer goodid);
    List<Image> getAllimage(Integer goodid);
    int insert(Cart record);
    int update(Cart record);
    List<FirstSort> getFsSort(Integer goodid);
    List<Goods> getAllgoods(int goodid);
    int getGoodsId(String goods_name);
}
