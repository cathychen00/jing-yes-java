package com.jingyesjava.io;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * RandomAccessFile 支持随机访问文件进行读写
 * 参考：https://www.cnblogs.com/c1024/p/11012003.html
 */
public class RandomAccessFileDemo {
    public static void main(String[] args) throws IOException {
//        writeFile();
        copyFile();
    }

    /**
     * 写入文档
     */
    private static void writeFile() throws IOException {
        String filePath = "D:\\data\\testlogs\\test.txt";
        RandomAccessFile raf = new RandomAccessFile(filePath, "rw");
        raf.write("测试一下".getBytes());
        raf.close();
    }

    /**
     * 多线程分段传输
     */
    private static void copyFile() {
        String filePath = "D:\\data\\testlogs\\th.jpg";
        // 这里声明为偶数片数，下面会进行计算
        int parts = 2;
        File file = new File(filePath);
        long len = file.length();
        // 防止除法出校小数点，必须能整除才行
        if (len % 2 == 0) {
            parts *= 2;
        } else if (len % 2 == 0) {
            parts = parts * 2 - 1;
        }

        for (int i = 0; i < parts; i++) {
            // 启动线程
            new ReadCopyMoreThreadFile(i, parts, file).start();
        }

        System.out.println("多线程复制文件成功");
    }

    static class ReadCopyMoreThreadFile extends Thread {

        private int start = 0;
        private int parts = 0;
        private File file;

        public ReadCopyMoreThreadFile(int start, int parts, File file) {
            this.start = start;
            this.file = file;
            this.parts = parts;
        }

        @Override
        public void run() {
            System.out.println("第" + start + "个线程正在运行！");
            try {
                RandomAccessFile rf = new RandomAccessFile(file, "rw");

                // 获取到文件的总长度
                long len = rf.length();

                /*
                 *
                 * 5174 * 0 / 2 = 0 5174 * 1 / 2 = 2587
                 *
                 * 跳到第start部分开始读
                 */
                rf.seek(len * start / parts);
                byte[] buf = new byte[(int) (len / parts)];
                // 读取
                rf.read(buf);
                // 关闭
                rf.close();

                int index = file.getName().lastIndexOf(".");

                String newFileName = "D:\\data\\testlogs\\th_bak.jpg";
                // 创建目标文件
                rf = new RandomAccessFile(newFileName, "rw");
                // 指针移动到需要写的位置
                rf.seek(len * start / parts);
                // 写入
                rf.write(buf);
                // 关闭
                rf.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
