package com.jingyes.j2se.tests.enumtests;

/**
 * @author jingyes
 */
public enum EnumOperType {
    ADD(1, "新增一个用户"),
    MODIFY(2, "修改用户信息"),
    DELETE(3, "删除用户");
    private int index;
    private String description;

    private EnumOperType(int index, String description) {
        this.index = index;
        this.description = description;
    }
}
