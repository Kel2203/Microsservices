package com.javalearn.hroauth.feignclients;

import com.javalearn.hroauth.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeingClient(name = "hr-user", path="/users")
@Component
public interface UserFeignClient {

    @GetMapping(value = "/search")
    public ResponseEntity<User> findByEmail(@RequestParam String email);
}
