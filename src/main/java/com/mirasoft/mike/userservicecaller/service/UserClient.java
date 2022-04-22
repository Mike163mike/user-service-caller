package com.mirasoft.mike.userservicecaller.service;

import com.mirasoft.mike.userservicecaller.dto.UserDto;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
@Getter
@Setter
public class UserClient {

    private UserDto userDto;
    private String url;
    private RestTemplate restTemplate;

    public UserDto getUserFromUserService(String url) {
        return restTemplate.getForObject(url, UserDto.class);
    }
}
