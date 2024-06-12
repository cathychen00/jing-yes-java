package org.jingyes.designpattern.Creational.converter;

import java.util.Date;

/**
 * @author jingyes
 * @date 2024/1/15
 */
public class DataDTO {
    private Integer id;
    private String title;
    private Date delayTime;

    private Boolean isDelay;

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

    public Boolean getDelay() {
        return isDelay;
    }

    public void setDelay(Boolean delay) {
        isDelay = delay;
    }

    @Override
    public String toString() {
        return "DataDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", delayTime=" + delayTime +
                ", isDelay=" + isDelay +
                '}';
    }
}
