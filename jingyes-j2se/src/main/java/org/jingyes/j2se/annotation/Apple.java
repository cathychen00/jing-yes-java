package org.jingyes.j2se.annotation;

/**
 * @author jingyes
 * @date 2021/4/6
 */
public class Apple {
    @FruitProvider(id = 1, name = "aaa", address = "bbb")
    private String appleSupplier;

    public String getAppleSupplier() {
        return appleSupplier;
    }

    public void setAppleSupplier(String appleSupplier) {
        this.appleSupplier = appleSupplier;
    }
}
