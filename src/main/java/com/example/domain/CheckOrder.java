package com.example.domain;

import java.util.Date;

public class CheckOrder {
    private Integer id;

    private String carNo;

    private String defectDesc;

    private String inportanceCode;

    private Integer frequency;

    private Double foldingFrequency;

    private Integer resDepartmentId;

    private Integer resUserId;

    private Integer resDepartmentLeaderId;

    private String process;

    private String defect;

    private Integer checkNum;

    private Double debit;

    private Double liaderDebit;

    private Integer weekNum;

    private String pictureUrl;

    private Date createTime;

    private Date updateTime;

    private String flag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCarNo() {
        return carNo;
    }

    public void setCarNo(String carNo) {
        this.carNo = carNo;
    }

    public String getDefectDesc() {
        return defectDesc;
    }

    public void setDefectDesc(String defectDesc) {
        this.defectDesc = defectDesc;
    }

    public String getInportanceCode() {
        return inportanceCode;
    }

    public void setInportanceCode(String inportanceCode) {
        this.inportanceCode = inportanceCode;
    }

    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }

    public Double getFoldingFrequency() {
        return foldingFrequency;
    }

    public void setFoldingFrequency(Double foldingFrequency) {
        this.foldingFrequency = foldingFrequency;
    }

    public Integer getResDepartmentId() {
        return resDepartmentId;
    }

    public void setResDepartmentId(Integer resDepartmentId) {
        this.resDepartmentId = resDepartmentId;
    }

    public Integer getResUserId() {
        return resUserId;
    }

    public void setResUserId(Integer resUserId) {
        this.resUserId = resUserId;
    }

    public Integer getResDepartmentLeaderId() {
        return resDepartmentLeaderId;
    }

    public void setResDepartmentLeaderId(Integer resDepartmentLeaderId) {
        this.resDepartmentLeaderId = resDepartmentLeaderId;
    }

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process;
    }

    public String getDefect() {
        return defect;
    }

    public void setDefect(String defect) {
        this.defect = defect;
    }

    public Integer getCheckNum() {
        return checkNum;
    }

    public void setCheckNum(Integer checkNum) {
        this.checkNum = checkNum;
    }

    public Double getDebit() {
        return debit;
    }

    public void setDebit(Double debit) {
        this.debit = debit;
    }

    public Double getLiaderDebit() {
        return liaderDebit;
    }

    public void setLiaderDebit(Double liaderDebit) {
        this.liaderDebit = liaderDebit;
    }

    public Integer getWeekNum() {
        return weekNum;
    }

    public void setWeekNum(Integer weekNum) {
        this.weekNum = weekNum;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}