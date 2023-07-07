package com.rubincomputers.springboot01.dto;

import com.rubincomputers.springboot01.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {
    private Long id;
    private String login;
    private String firstName;
    private String lastName;

    public static UserDTO from(User user){
        return UserDTO.builder().id(user.getId()).login(user.getLogin()).firstName(user.getFirstName()).lastName(user.getLastName()).build();
    }
}
