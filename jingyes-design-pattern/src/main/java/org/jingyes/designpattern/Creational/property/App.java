package org.jingyes.designpattern.Creational.property;

/**
 * 并结合原型模式，动态设置属性，从已有对象构建新的对象
 *
 * @author jingyes
 * @date 2024/1/22
 */
public class App {
    public static void main(String[] args) {
        Charactor prototype = new Charactor();
        prototype.set(EnumStatType.RAGE, 1);
        prototype.set(EnumStatType.AGILITY, 2);

        Charactor c1 = new Charactor(prototype, "c1");
        System.out.println(c1);

        Charactor c2 = new Charactor(c1, "c2");
        c2.set(EnumStatType.INTELLECT, 3);
        System.out.println(c1.has(EnumStatType.INTELLECT));
        System.out.println(c2.has(EnumStatType.INTELLECT));
        System.out.println(c2);
    }
}
