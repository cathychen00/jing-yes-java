package org.jingyes.designpattern.Creational.monostate;

import java.util.ArrayList;
import java.util.List;

/**
 * 实现monostate模式，模拟服务器负载均衡
 *
 * @author jingyes
 * @date 2024/1/18
 */
public class LoadBalance {
    private static List<Server> servers = new ArrayList<>();

    static {
        for (int i = 0; i < 3; i++) {
            servers.add(new Server(i, "localhost", 8080 + i));
        }
    }

    //多个负载均衡集群，仍然会按照顺序分发服务器
    private static Integer server_index = 0;

    public void addServer(Server server) {
        synchronized (servers) {
            servers.add(server);
        }
    }

    /**
     * 通过轮询方式分发给服务器响应
     *
     * @param request
     */
    public void processRequest(Request request) {
        if (server_index.equals(servers.size())) {
            server_index = 0;
        }
        Server selectServer = servers.get(server_index++);
        selectServer.processRequest(request);
    }
}
