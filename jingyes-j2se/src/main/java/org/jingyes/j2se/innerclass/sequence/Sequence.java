package org.jingyes.j2se.innerclass.sequence;

/**
 * 内部类分别实现接口，正序和逆序遍历
 *
 * @author 陈敬
 * @date 2018/6/16
 */
public class Sequence {
    private int next;
    private Object[] items;

    public Sequence(int size) {
        items = new Object[size];
    }

    public void addObject(Object o) {
        if (next < items.length) {
            items[next] = o;
            next++;
        }
    }

    /**
     * 正序遍历实例
     */
    public Selector selector() {
        return new SequenceSelector();
    }

    /**
     * 倒序遍历实例
     */
    public Selector reverseSelector() {
        return new ReverseSelector();
    }

    /**
     * 内部类，实现正序遍历
     */
    private class SequenceSelector implements Selector {
        private int i = 0;

        @Override
        public boolean end() {
            return i == items.length;
        }

        @Override
        public void next() {
            if (i < items.length) {
                i++;
            }
        }

        @Override
        public Object current() {
            return items[i];
        }
    }

    /**
     * 内部类，实现倒序遍历
     */
    private class ReverseSelector implements Selector {
        int i = items.length - 1;

        @Override
        public boolean end() {
            return i == -1;
        }

        @Override
        public void next() {
            if (i >= 0) {
                i--;
            }
        }

        @Override
        public Object current() {
            return items[i];
        }
    }
}
