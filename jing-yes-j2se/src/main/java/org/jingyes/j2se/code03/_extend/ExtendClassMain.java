package org.jingyes.j2se.code03._extend;

/**
 * 几个继承和多态示例
 *
 * @author jingyes
 * @date 2023-8-28
 */
public class ExtendClassMain {
    public static void main(String[] args) {
        testConstructor();
        testOverload();
        testParent();
        dynamicBind();
    }

    public static void testConstructor() {
        Bread bread = new Bread("毛毛虫面包", 10);
    }


    public static void testOverload() {
        Bread bread = new Bread("豆沙面包", 9);
        bread.display();
        bread.display("味多美");
    }


    public static void testParent() {
        Product product = new Bread("毛毛虫面包", 10);
        product.display();

        //强制类型转换
        if (product instanceof Bread) {
            Bread brand = (Bread) product;
            brand.display("味多美");
        }
    }


    public static void dynamicBind() {
        Product product = new Product("product");
        product.display();  //[Product]getDescription()

        Bread bread = new Bread("毛毛虫", 9);
        bread.display();  //[Bread]getDescription()
        bread.display("maimai");  //[Bread]getDescription(String storeName)

        Product product1 = bread;
        product1.display();  //[Bread]getDescription()
    }
}
