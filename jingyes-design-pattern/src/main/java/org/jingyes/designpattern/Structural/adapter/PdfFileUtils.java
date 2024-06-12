package org.jingyes.designpattern.Structural.adapter;

/**
 * 需要被适配的类
 * @author jingyes
 * @date 2024/1/15
 */
public class PdfFileUtils {
    public String readFile(String file){
        return "read pdf file,filename="+file;
    }
    public void writeFile(String text){
        System.out.println("write pdf file,text="+text);
    }
}
