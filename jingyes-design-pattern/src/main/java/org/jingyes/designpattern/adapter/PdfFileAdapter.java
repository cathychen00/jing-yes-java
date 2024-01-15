package org.jingyes.designpattern.adapter;

/**
 * 适配器类
 * @author 陈敬
 * @date 2024/1/15
 */
public class PdfFileAdapter implements FileReader {
    private PdfFileUtils pdfFileUtils;

    public PdfFileAdapter(PdfFileUtils pdfFileUtils) {
        this.pdfFileUtils = pdfFileUtils;
    }

    @Override
    public String read(String filename) {
        return this.pdfFileUtils.readFile(filename);
    }
}
