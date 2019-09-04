package org.lanqiao.jd.entity;

public class Address {
    private Integer address_id;

    private String receive_name;

    private Integer provice_id;

    private Integer city_id;

    private Integer district_id;

    private String street;

    private String zipcode;

    private String telephone;

    private String default_add;

    private Integer user_id;

    public Integer getAddress_id() {
        return address_id;
    }

    public void setAddress_id(Integer address_id) {
        this.address_id = address_id;
    }

    public String getReceive_name() {
        return receive_name;
    }

    public void setReceive_name(String receive_name) {
        this.receive_name = receive_name == null ? null : receive_name.trim();
    }

    public Integer getProvice_id() {
        return provice_id;
    }

    public void setProvice_id(Integer provice_id) {
        this.provice_id = provice_id;
    }

    public Integer getCity_id() {
        return city_id;
    }

    public void setCity_id(Integer city_id) {
        this.city_id = city_id;
    }

    public Integer getDistrict_id() {
        return district_id;
    }

    public void setDistrict_id(Integer district_id) {
        this.district_id = district_id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street == null ? null : street.trim();
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode == null ? null : zipcode.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String getDefault_add() {
        return default_add;
    }

    public void setDefault_add(String default_add) {
        this.default_add = default_add == null ? null : default_add.trim();
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }
}