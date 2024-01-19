package org.jingyes.designpattern.Creational.monostate;

/**
 * @author 陈敬
 * @date 2024/1/18
 */
public class Request {
    private String param;

    public Request(String param) {
        this.param = param;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }
}
