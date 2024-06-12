package org.jingyes.concurrent.juc.threadsnyc;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * 线程通信4：管道 PipedReader和PipedWriter
 *
 * @author chenjing
 */
public class PipedReaderWriterDemo {
    public static void main(String[] args) throws IOException {
        PipedReader pipedReader = new PipedReader();
        PipedWriter pipedWriter = new PipedWriter();

        Thread writerThread = new Thread(() -> {
            try {
                for (int i = 65; i < 70; i++) {
                    pipedWriter.write((char) i);
                }
                Thread.sleep(1000);
                pipedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread readerThread = new Thread(() -> {
            int i;
            try {
                while ((i = pipedReader.read()) != -1) {
                    System.out.println((char) i);
                }
                Thread.sleep(1000);
                pipedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        //注意要进行connect
        pipedReader.connect(pipedWriter);

        readerThread.start();
        writerThread.start();
    }
}
