package com.jingyes.j2se.tests.transienttests;

import java.io.Serializable;

/**
 * @author jingyes
 * @date 2022/2/17
 */
public class Book implements Serializable {
    private static final long serialVersionUID = -2936687026040726549L;
    //final transient new String
    private final transient String category2 = new String("Math");
    private String bookName;
    //注意一下关键字final transient的情况
    private final transient String category = "Math";
    private transient String description;
    private transient int copies;


    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCopies() {
        return copies;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }

    public String getCategory() {
        return category;
    }

    public String getCategory2() {
        return category2;
    }
}