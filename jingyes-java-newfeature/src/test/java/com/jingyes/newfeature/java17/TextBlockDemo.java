package com.jingyes.newfeature.java17;

/**
 * JAVA17 文本块，连续三个双引号，适用于引号、换行、json字符串等
 *
 * @author 陈敬
 * @date 2024/1/2
 */
public class TextBlockDemo {
    public static void main(String[] args) {
        String s = """
                测试
                字符串可以换行了
                不用拼接了""";
        System.out.println(s);

        String json = """
                {
                  "name": "测试json字符串",
                  "age": 18
                }
                """;
        System.out.println(json);
    }
}
