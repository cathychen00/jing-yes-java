package org.jingyes.designpattern.adapter;

/**
 * @author 陈敬
 * @date 2024/1/15
 */
public class App {
    public static void main(String[] args) {
        PdfFileUtils pdfFileUtils=new PdfFileUtils();
        PdfFileAdapter pdfFileAdapter=new PdfFileAdapter(pdfFileUtils);
        String text=pdfFileAdapter.read("java tutor");
        System.out.println(text);
    }
}
