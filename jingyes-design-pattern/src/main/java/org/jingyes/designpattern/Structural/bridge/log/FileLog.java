package org.jingyes.designpattern.Structural.bridge.log;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author jingyes
 * @date 2023/12/4
 */
public class FileLog implements Log {
    private String fileName;

    public String getFileName() {
        String format = "yyyy-MM-dd";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        String formattedTime = LocalDateTime.now().format(formatter);
        return "log" + formattedTime + ".txt";
    }

    @Override
    public void write(String message) {
        System.out.println("*************文件日志*************\r\n" + this.getFileName() + ">" + message);
    }
}
