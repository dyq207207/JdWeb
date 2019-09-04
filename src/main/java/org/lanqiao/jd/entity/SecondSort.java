package org.lanqiao.jd.entity;

public class SecondSort {
    private Integer two_sort_id;

    private String two_sort_name;

    private Integer first_sort_id;

    public Integer getTwo_sort_id() {
        return two_sort_id;
    }

    public void setTwo_sort_id(Integer two_sort_id) {
        this.two_sort_id = two_sort_id;
    }

    public String getTwo_sort_name() {
        return two_sort_name;
    }

    public void setTwo_sort_name(String two_sort_name) {
        this.two_sort_name = two_sort_name == null ? null : two_sort_name.trim();
    }

    public Integer getFirst_sort_id() {
        return first_sort_id;
    }

    public void setFirst_sort_id(Integer first_sort_id) {
        this.first_sort_id = first_sort_id;
    }
}