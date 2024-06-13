package com.jingyes.webflux;


import com.jingyes.webflux.pojo.EnumSex;
import com.jingyes.webflux.pojo.User;
import com.jingyes.webflux.vo.UserVo;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author chenjing
 * @date 2021/3/22
 */
public class WebClientDemo {
    public static void main(String[] args) {
        WebClient webClient = WebClient.create("http://localhost:8080");
        User newUser = new User();
        newUser.setId(1L);
        newUser.setUserName("user1");
        newUser.setNote("note1");
        newUser.setSex(EnumSex.FEMAIL);
        insertUser(webClient, newUser);

        getUser(webClient, 1L);

        User updateUser = new User();
        updateUser.setId(2L);
        updateUser.setUserName("user2");
        updateUser.setNote("note2");
        updateUser.setSex(EnumSex.MAIL);
        updateUser(webClient, updateUser);

        getUser(webClient, 2L);

        findUsers(webClient, "user", "note");

    }

    private static void findUsers(WebClient webClient, String user, String note) {
        Map<String, Object> param = new HashMap<>();
        param.put("userName", user);
        param.put("note", note);

        Flux<UserVo> flux = webClient
                .get()
                .uri("/user/{userName}/{note}", param)
                .accept(MediaType.APPLICATION_STREAM_JSON)
                .retrieve()
                .bodyToFlux(UserVo.class);
        Iterator<UserVo> iterator = flux.toIterable().iterator();
        while (iterator.hasNext()) {
            System.out.println(">>>findUsers:");
            UserVo next = iterator.next();
            System.out.println(next.getUserName());
        }
    }

    private static void updateUser(WebClient webClient, User updateUser) {
        Mono<UserVo> mono = webClient
                .put()
                .uri("/user")
                .contentType(MediaType.APPLICATION_STREAM_JSON)
                .body(Mono.just(updateUser), User.class)
                .accept(MediaType.APPLICATION_STREAM_JSON)
                .retrieve()
                .bodyToMono(UserVo.class);
        UserVo userVo = mono.block();
        System.out.println(">>>updateUser,userName=" + userVo.getUserName());
    }

    private static void insertUser(WebClient webClient, User newUser) {
        Mono<UserVo> mono = webClient
                .post()
                .uri("/user")
                .contentType(MediaType.APPLICATION_STREAM_JSON)
                .body(Mono.just(newUser), User.class)
                .accept(MediaType.APPLICATION_STREAM_JSON)
                .retrieve()
                .bodyToMono(UserVo.class);
        UserVo userVo = mono.block();
        System.out.println(">>>insertUser,userName=" + userVo.getUserName());
    }

    private static void getUser(WebClient webClient, Long id) {
        Mono<UserVo> mono = webClient
                .get()
                .uri("/user/{id}", 1)
                .accept(MediaType.APPLICATION_STREAM_JSON)
                .retrieve()
                //异常状态码处理
                .onStatus(x -> x.is4xxClientError() || x.is5xxServerError()
                        , response -> Mono.empty())
                .bodyToMono(UserVo.class);
        UserVo userVo = mono.block();
        if (userVo != null) {
            System.out.println(">>>getUser, " + userVo.toString());
        } else {
            System.out.println("服务器异常，未正常返回");
        }
    }
}
