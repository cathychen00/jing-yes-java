package org.jingyes.designpattern.Creational.monostate;

/**
 * @author jingyes
 * @date 2024/1/18
 */
public class App {
    public static void main(String[] args) {
        //负载均衡1
        LoadBalance loadBalance = new LoadBalance();
        //负载均衡2,继续分配服务器
        LoadBalance loadBalance2=new LoadBalance();

        for (int i = 0; i < 5; i++) {
            loadBalance.processRequest(new Request("aaa=" + i));
        }
        //新增一台服务器
        loadBalance.addServer(new Server(3, "localhost", 9090));
        System.out.println("**********");

        for (int i = 0; i < 5; i++) {
            loadBalance.processRequest(new Request("aaa=" + i));
            loadBalance2.processRequest(new Request("bbb=" + i));
        }
    }
}
