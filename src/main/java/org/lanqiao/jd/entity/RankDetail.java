package org.lanqiao.jd.entity;

public class RankDetail {
    private Integer rankDetailId;

    private String rankDetailName;

    private Integer rankId;

    public Integer getRankDetailId() {
        return rankDetailId;
    }

    public void setRankDetailId(Integer rankDetailId) {
        this.rankDetailId = rankDetailId;
    }

    public String getRankDetailName() {
        return rankDetailName;
    }

    public void setRankDetailName(String rankDetailName) {
        this.rankDetailName = rankDetailName == null ? null : rankDetailName.trim();
    }

    public Integer getRankId() {
        return rankId;
    }

    public void setRankId(Integer rankId) {
        this.rankId = rankId;
    }
}