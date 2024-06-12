package org.jingyes.designpattern.Creational.monostate;

/**
 * @author jingyes
 * @date 2024/1/18
 */
public class Server {
    private Integer serverId;
    private String host;
    private Integer port;

    public Server(Integer serverId, String host, Integer port) {
        this.serverId = serverId;
        this.host = host;
        this.port = port;
    }

    public Integer getServerId() {
        return serverId;
    }

    public void setServerId(Integer serverId) {
        this.serverId = serverId;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public void processRequest(Request request) {
        System.out.println("[server" + this.getServerId()+" " + this.getHost() + ":" + this.getPort() + "]处理请求 " + request.getParam());
    }
}
