package org.lanqiao.jd.entity;

import java.util.Date;
import java.util.List;
import java.util.Set;

public class Goods {
    private Classfy classfy;
    private Brand brand;

    public Classfy getClassfy() {
        return classfy;
    }

    public void setClassfy(Classfy classfy) {
        this.classfy = classfy;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }
    private Integer classfy_id;

    public Integer getClassfy_id() {
        return classfy_id;
    }

    public void setClassfy_id(Integer classfy_id) {
        this.classfy_id = classfy_id;
    }

    private Integer goods_id;

    private String goods_name;

    private Integer sort_id;

    private Integer img_id;

    private Double price;

    private Integer goods_num;

    private Integer brands_id;

    private Integer goods_sales;

    private Date goods_create_time;

    private Set<Image> imageSet;

    public Set<Image> getImageSet() {
        return imageSet;
    }

    public void setImageSet(Set<Image> imageSet) {
        this.imageSet = imageSet;
    }

    public Integer getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(Integer goods_id) {
        this.goods_id = goods_id;
    }

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name == null ? null : goods_name.trim();
    }

    public Integer getSort_id() {
        return sort_id;
    }

    public void setSort_id(Integer sort_id) {
        this.sort_id = sort_id;
    }

    public Integer getImg_id() {
        return img_id;
    }

    public void setImg_id(Integer img_id) {
        this.img_id = img_id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getGoods_num() {
        return goods_num;
    }

    public void setGoods_num(Integer goods_num) {
        this.goods_num = goods_num;
    }

    public Integer getBrands_id() {
        return brands_id;
    }

    public void setBrands_id(Integer brands_id) {
        this.brands_id = brands_id;
    }

    public Integer getGoods_sales() {
        return goods_sales;
    }

    public void setGoods_sales(Integer goods_sales) {
        this.goods_sales = goods_sales;
    }

    public Date getGoods_create_time() {
        return goods_create_time;
    }

    public void setGoods_create_time(Date goods_create_time) {
        this.goods_create_time = goods_create_time;
    }
}