package org.jingyes.designpattern.Creational.property;

/**
 * @author jingyes
 * @date 2024/1/22
 */
public interface Prototype {
    void set(EnumStatType statType,Integer value);
    Integer get(EnumStatType statType);
    boolean has(EnumStatType statType);
    void remove(EnumStatType statType);
}
