package com.example.domain;

import java.util.Date;

public class Area {
    private String areaCode;

    private String areaName;

    private String shortName;

    private String areaLevel;

    private String parentCode;

    private String hotFlag;

    private String validStatus;

    private String licensePrefix;

    private String provinceFlag;

    private String operatorCode;

    private String operatorName;

    private Date operatorDate;

    private String feeChangeFlag;

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode == null ? null : areaCode.trim();
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName == null ? null : areaName.trim();
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName == null ? null : shortName.trim();
    }

    public String getAreaLevel() {
        return areaLevel;
    }

    public void setAreaLevel(String areaLevel) {
        this.areaLevel = areaLevel == null ? null : areaLevel.trim();
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode == null ? null : parentCode.trim();
    }

    public String getHotFlag() {
        return hotFlag;
    }

    public void setHotFlag(String hotFlag) {
        this.hotFlag = hotFlag == null ? null : hotFlag.trim();
    }

    public String getValidStatus() {
        return validStatus;
    }

    public void setValidStatus(String validStatus) {
        this.validStatus = validStatus == null ? null : validStatus.trim();
    }

    public String getLicensePrefix() {
        return licensePrefix;
    }

    public void setLicensePrefix(String licensePrefix) {
        this.licensePrefix = licensePrefix == null ? null : licensePrefix.trim();
    }

    public String getProvinceFlag() {
        return provinceFlag;
    }

    public void setProvinceFlag(String provinceFlag) {
        this.provinceFlag = provinceFlag == null ? null : provinceFlag.trim();
    }

    public String getOperatorCode() {
        return operatorCode;
    }

    public void setOperatorCode(String operatorCode) {
        this.operatorCode = operatorCode == null ? null : operatorCode.trim();
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName == null ? null : operatorName.trim();
    }

    public Date getOperatorDate() {
        return operatorDate;
    }

    public void setOperatorDate(Date operatorDate) {
        this.operatorDate = operatorDate;
    }

    public String getFeeChangeFlag() {
        return feeChangeFlag;
    }

    public void setFeeChangeFlag(String feeChangeFlag) {
        this.feeChangeFlag = feeChangeFlag == null ? null : feeChangeFlag.trim();
    }
}