package com.example.common.enums;

/**
 * Created by zhuyy on 2017/3/27.
 */
public enum ImportanceEnum {
    BC("BC", "BC"),
    BB("BB", "BB");

    private String code;
    private String desc;

    private ImportanceEnum(String code, String desc) {
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
        throw new IllegalArgumentException("No Enum Code '" + code + "'. " + ImportanceEnum.class);
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
