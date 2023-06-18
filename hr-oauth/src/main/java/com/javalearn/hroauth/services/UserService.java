package com.javalearn.hroauth.services;

import com.javalearn.hroauth.entities.User;
import com.javalearn.hroauth.feignclients.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private static Logger logger = LoggerFactory.getLogger(UserService.class);
    @Autowired
    private UserFeignClient userFeignClient;

    public User findByEmail(String email){
        User user = userFeignClient.findByEmail(email).getBody();
        if(user == null){
            logger.error("Email not found" + email);
            throw new IllegalArgumentException("Email not found!");

        }
        logger.info("Email found: " + email);
        return user;
    }
}
