package com.jingyes.j2se.tests.transienttests;

import org.junit.Assert;
import org.junit.Test;

/**
 * transient关键字，用来修饰变量
 * 1.序列化时字段会被忽略，反序列化时为字段默认值
 * 2.注意一下关键字final + transient的几种情况
 * 参考：https://www.baeldung.com/java-transient-keyword
 * Serialization is the process of converting an object into a byte stream, and deserialization is the opposite of it.
 * When we mark any variable as transient, then that variable is not serialized.
 *
 * @author jingyes
 * @date 2022/2/17
 */
public class TransientTests {

    @Test
    public void test() throws Exception {
        Book book = new Book();
        book.setBookName("Java Reference");
        book.setDescription("will not be saved");
        book.setCopies(25);
        BookDeSer.serialize(book);

        book = BookDeSer.deserialize();

        //非transient字段
        Assert.assertEquals("Java Reference", book.getBookName());
        //transient字段，默认值
        Assert.assertNull(book.getDescription());
        Assert.assertEquals(0, book.getCopies());
//        final transient +字符串常量，初始化后不能被改变，因此编译时就保存在了常量池
        Assert.assertEquals("Math", book.getCategory());
//        final transient +new String()，反序列化null
        Assert.assertNull("Math", book.getCategory2());
    }
}
