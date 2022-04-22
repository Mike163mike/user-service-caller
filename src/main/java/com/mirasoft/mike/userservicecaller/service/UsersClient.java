package com.mirasoft.mike.userservicecaller.service;

import com.mirasoft.mike.userservicecaller.dto.UserDto;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Component
@Getter
@Setter
public class UsersClient {

    private String url;
    private RestTemplate restTemplate;

    public List<UserDto> getUsersFromUserService(String url) {
        ResponseEntity<UserDto[]> response = restTemplate.getForEntity(url, UserDto[].class);
         return List.of(Objects.requireNonNull(response.getBody()));
    }
}
