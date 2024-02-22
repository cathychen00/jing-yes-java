package com.jingyes.j2se.tests.collection;

import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * Priority queue 优先级队列。数组实现的完全二叉树，小顶堆
 */
public class PriorityQueueTests {
    public static void main(String[] args) {
        //创建优先级队列，自定义排序
        PriorityQueue<String> priorityQueue = new PriorityQueue<>((o1, o2) -> {
            //先按照字符串长度排序
            if (o1.length() > o2.length()) {
                return 1;
            }
            //在按照字符串默认排序
            return o1.compareTo(o2);
        });

        //添加元素，相当于add()
        priorityQueue.offer("aa");
        priorityQueue.offer("bb");
        priorityQueue.offer("abc");
        priorityQueue.offer("ab");

        //遍历队列
        Iterator<String> iterator = priorityQueue.iterator();
        while (iterator.hasNext()) {
            System.out.println(priorityQueue.poll());
        }
        //输出结果
//        aa
//        ab
//        bb
//        abc
    }
}
