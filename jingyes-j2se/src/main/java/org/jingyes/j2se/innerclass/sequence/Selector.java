package org.jingyes.j2se.innerclass.sequence;

/**
 * 顺序遍历的接口
 *
 * @author 陈敬
 * @date 2018/6/16
 */
public interface Selector {
    /**
     * 是否最后一个元素
     */
    boolean end();

    /**
     * 移动到下一个元素
     */
    void next();

    /**
     * 获取当前位置的值
     */
    Object current();
}