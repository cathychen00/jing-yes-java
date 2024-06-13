package com.jingyes.webflux.controllers;

import com.jingyes.webflux.pojo.User;
import com.jingyes.webflux.service.UserService;
import com.jingyes.webflux.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author chenjing
 * @date 2021/3/22
 */
@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/user/{id}")
    public Mono<UserVo> getUser(@PathVariable Long id) {
        return this.userService.getUser(id)
                .map(u -> translate(u));
    }

    @PostMapping("/user")
    public Mono<UserVo> insertUser(@RequestBody User user) {
        return this.userService.insertUser(user)
                .map(u -> translate(u));
    }

    @PutMapping("/user")
    public Mono<UserVo> updateUser(@RequestBody User user) {
        return this.userService.updateUser(user)
                .map(u -> translate(u));
    }

    @DeleteMapping("/user/{id}")
    public Mono<Void> deleteUser(@PathVariable Long id) {
        return this.userService.deleteUser(id);
    }

    @GetMapping("/user/{userName}/{note}")
    public Flux<UserVo> findUsers(@PathVariable String userName, @PathVariable String note) {
        return this.userService.findUsers(userName, note)
                .map(u -> translate(u));
    }

    private UserVo translate(User u) {
        UserVo vo = new UserVo();
        vo.setId(u.getId());
        vo.setUserName(u.getUserName());
        vo.setNote(u.getNote());
        vo.setSexCode(u.getSex().getCode());
        vo.setSexName(u.getSex().getName());
        return vo;
    }
}
