package com.mirasoft.mike.userservicecaller.config;

import com.mirasoft.mike.userservicecaller.service.UserClient;
import com.mirasoft.mike.userservicecaller.service.UsersClient;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;


@Configuration
@PropertySource("classpath:application.yaml")
public class AppConfig {

    @Value("${targetUrl}")
    private String url;

@Bean
    public RestTemplate bean() {
        HttpClient httpClient = HttpClientBuilder.create().build();
        ClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory(httpClient);
        return new RestTemplate(factory);
    }

    @Bean
    public UserClient UserBean() {
        UserClient userClient = new UserClient();
        userClient.setUrl(url);
        userClient.setRestTemplate(new RestTemplate());
        return userClient;
    }

    @Bean
    public UsersClient UsersBean() {
        UsersClient usersClient = new UsersClient();
        usersClient.setUrl(url);
        usersClient.setRestTemplate(new RestTemplate());
        return usersClient;
    }
}
