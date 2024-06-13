package com.jingyes.webflux.pojo;

/**
 * @author chenjing
 * @date 2021/3/22
 */
public enum EnumSex {
    MAIL(1, "男"),
    FEMAIL(0, "女");
    private int code;
    private String name;

    EnumSex(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public static EnumSex getEnumSex(int code) {
        EnumSex[] values = EnumSex.values();
        for (EnumSex item : values) {
            if (item.code == code) {
                return item;
            }
        }
        return null;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
