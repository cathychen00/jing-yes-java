package com.jingyes.newfeature.java11;


import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * @author jingyes
 * @date 2021/1/28
 */
public class HttpClientTests {
    public static void main(String[] args) throws IOException, InterruptedException {
        var request = HttpRequest.newBuilder()
                .uri(URI.create("https://www.baidu.com"))
                .GET()
                .build();

        var client = HttpClient.newHttpClient();
// 同步
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());

// 异步

//        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
//
//                .thenApply(HttpResponse::body)
//
//                .thenAccept(System.out::println);
    }
}
