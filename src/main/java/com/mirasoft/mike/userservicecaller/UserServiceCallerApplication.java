package com.mirasoft.mike.userservicecaller;

import com.mirasoft.mike.userservicecaller.config.AppConfig;
import com.mirasoft.mike.userservicecaller.dto.UserDto;
import com.mirasoft.mike.userservicecaller.service.UsersClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.*;

import java.net.URISyntaxException;

@SpringBootApplication
@Component
public class UserServiceCallerApplication {

    public static void main(String[] args) throws URISyntaxException {

        SpringApplication.run(UserServiceCallerApplication.class, args);

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//        UserClient userClient = context.getBean("UserBean", UserClient.class);
//        String url1 = userClient.getUrl();
//        UserDto userDto = userClient.getUserFromUserService(url1);
//        System.out.println(userDto);

        UsersClient usersClient = context.getBean("UsersBean", UsersClient.class);
        String url = usersClient.getUrl();
        List<UserDto> usersDto = usersClient.getUsersFromUserService(url);
        for (UserDto usr : usersDto) {
            System.out.println(usr);
        }
    }
}
