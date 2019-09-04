package org.lanqiao.jd.entity;

public class FirstSort {
    private Integer first_sort_id;

    private String first_sort_name;

    public Integer getFirst_sort_id() {
        return first_sort_id;
    }

    public void setFirst_sort_id(Integer first_sort_id) {
        this.first_sort_id = first_sort_id;
    }

    public String getFirst_sort_name() {
        return first_sort_name;
    }

    public void setFirst_sort_name(String first_sort_name) {
        this.first_sort_name = first_sort_name == null ? null : first_sort_name.trim();
    }
}