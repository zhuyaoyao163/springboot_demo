package com.example.common.enums;

/**
 * Created by zhuyy on 2017/3/27.
 */
public enum ProcessEnum {
    GC("GC", "过程"),
    NB("NB", "内部"),
    HJ("HJ", "互检"),
    SCX("SCX", "生产线");

    private String code;
    private String desc;

    private ProcessEnum(String code, String desc) {
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
        throw new IllegalArgumentException("No Enum Code '" + code + "'. " + ProcessEnum.class);
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
