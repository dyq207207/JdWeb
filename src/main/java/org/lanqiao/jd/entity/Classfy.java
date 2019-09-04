package org.lanqiao.jd.entity;

import java.util.List;

public class Classfy {

    private List<Rank> rank;

    private Integer classfyId;

    private Integer parentClassfyId;

    private String classfyName;

    public Integer getClassfyId() {
        return classfyId;
    }

    public void setClassfyId(Integer classfyId) {
        this.classfyId = classfyId;
    }

    public Integer getParentClassfyId() {
        return parentClassfyId;
    }

    public void setParentClassfyId(Integer parentClassfyId) {
        this.parentClassfyId = parentClassfyId;
    }

    public String getClassfyName() {
        return classfyName;
    }

    public void setClassfyName(String classfyName) {
        this.classfyName = classfyName == null ? null : classfyName.trim();
    }

    public List<Rank> getRank() {
        return rank;
    }

    public void setRank(List<Rank> rank) {
        this.rank = rank;
    }
}