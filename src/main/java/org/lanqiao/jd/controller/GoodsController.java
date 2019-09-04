package org.lanqiao.jd.controller;

import org.lanqiao.jd.entity.*;
import org.lanqiao.jd.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GoodsController {
    @Autowired
    GoodsService goodsService;
    @RequestMapping("/getgoods")
    public List<Goods>getAllgoods(Integer goods_id){
        return goodsService.getAllgoods(goods_id);
    }
    @RequestMapping("/writecart")
    int insert(Cart record) {
        return goodsService.insert(record);
    }

    @RequestMapping("/updatecart")
    int update(Cart record) {
        return goodsService.update(record);
    }
    @RequestMapping("/getfsort")
    List<FirstSort> getFsSort(Integer goods_id){
        return goodsService.getFsSort(goods_id);
    }
    @RequestMapping("/getimages")
    public List<Image> getAllimage(Image image)
    {
        return goodsService.getAllimage(image.getGoodsId());
    }
    @RequestMapping("/getssort")
    List<SecondSort>getSsSort(Integer goods_id){
        return goodsService.getSsSort(goods_id);
    }
   @RequestMapping("/getGoodsId")
   public int getGoodsId(String goods_name){
        return goodsService.getGoodsId(goods_name);
   }

}
