package org.jingyes.designpattern.converter;

import java.util.Date;

/**
 * @author 陈敬
 * @date 2024/1/15
 */
public class Data {
    private Integer id;
    private String title;
    private Date delayTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDelayTime() {
        return delayTime;
    }

    public void setDelayTime(Date delayTime) {
        this.delayTime = delayTime;
    }
}
