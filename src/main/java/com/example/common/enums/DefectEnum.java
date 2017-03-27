package com.example.common.enums;

/**
 * Created by zhuyy on 2017/3/27.
 *
 */

public enum  DefectEnum {
    CLZ("CLZ", "错漏装"),
    DJCC("DJCC", "打胶粗糙"),
    FBBP("FBBP", "封板不平"),
    FBGDX("FBGDX", "封板鼓动响"),
    HJBDB("HJBDB", "焊接不达标"),
    HZ("HZ", "焊渣"),
    JBMF("JBMF", "胶不密封"),
    LDJ("LDJ", "漏打胶"),
    LH("LH", "漏焊"),
    LJ("LJ", "漏紧"),
    MPBP("MPBP", "蒙皮不平"),
    QHBBP("QHBBP", "前后保不平"),
    WX("WX", "歪斜"),
    WDM("WDM", "未打磨"),
    WQZ("WQZ", "未签字"),
    ZKBP("ZKBP", "止口不平");

    private String code;
    private String desc;

    private DefectEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static ImportanceEnum getEnum(String code) {
        for(ImportanceEnum e : ImportanceEnum.values())
        {
            if(code.equals(e.getCode()))
            {
                return e;
            }
        }
        throw new IllegalArgumentException("No Enum Code '" + code + "'. " + DefectEnum.class);
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return getCode() + " : " + getDesc();
    }
}
