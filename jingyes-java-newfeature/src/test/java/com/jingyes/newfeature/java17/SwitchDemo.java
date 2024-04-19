package com.jingyes.newfeature.java17;

/**
 * JAVA 12 switch
 * 使用类似 lambda 语法条件匹配成功后的执行块，不需要多写 break
 *
 * @author 陈敬
 * @date 2024/2/19
 */
public class SwitchDemo {
    public static void main(String[] args) {
        System.out.println(getName("video"));
        System.out.println(getName("article"));
        System.out.println(getName("aa"));
    }

    private static String getName(String type) {
        //switch可以返回值
        return switch (type) {
            case "article" -> "文章";
            //case代码块
            case "video" -> {
                System.out.println("当前类型是视频");
                //用yield返回结果
                yield "视频";
            }
            default -> throw new IllegalStateException("Unexpected value: " + type);
        };
    }
}
