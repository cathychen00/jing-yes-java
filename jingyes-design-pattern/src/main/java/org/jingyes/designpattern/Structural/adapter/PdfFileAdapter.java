package org.jingyes.designpattern.Structural.adapter;

/**
 * 适配器类
 * @author jingyes
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
