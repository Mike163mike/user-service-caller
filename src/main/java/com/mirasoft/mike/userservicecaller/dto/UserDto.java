package com.mirasoft.mike.userservicecaller.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDto {

    private Long id;
    private String surname;
    private String name;
    private String email;
    private String role;

    @Override
    public String toString() {
        return "User id: " + id + "\n"
                + "surname: " + surname + "\n"
                + "name: " + name + "\n"
                + "email: " + email + "\n"
                + "role: " + role + "\n"
                + "=======================";
    }
}
