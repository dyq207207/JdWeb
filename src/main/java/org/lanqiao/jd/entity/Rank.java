package org.lanqiao.jd.entity;

import java.util.List;

public class Rank {
    private List<RankDetail> rankDetail;
    private Integer rankId;

    private String rankName;

    private Integer classfyId;

    public Integer getRankId() {
        return rankId;
    }

    public void setRankId(Integer rankId) {
        this.rankId = rankId;
    }

    public String getRankName() {
        return rankName;
    }

    public void setRankName(String rankName) {
        this.rankName = rankName == null ? null : rankName.trim();
    }

    public Integer getClassfyId() {
        return classfyId;
    }

    public void setClassfyId(Integer classfyId) {
        this.classfyId = classfyId;
    }

    public List<RankDetail> getRankDetail() {
        return rankDetail;
    }

    public void setRankDetail(List<RankDetail> rankDetail) {
        this.rankDetail = rankDetail;
    }
}