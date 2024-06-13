package com.jingyes.webflux.repository;

import com.jingyes.webflux.pojo.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

/**
 * @author chenjing
 * @date 2021/3/22
 */
@Repository
public interface UserRepository extends ReactiveMongoRepository<User, Long> {
    Flux<User> findByUserNameLikeAndNoteLike(String userName, String note);
}
