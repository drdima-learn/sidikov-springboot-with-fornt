package com.rubincomputers.springboot01.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rubincomputers.springboot01.dto.UserDTO;
import com.rubincomputers.springboot01.form.UserForm;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User extends BaseEntity {

    public User(Long id, String login, String password, String firstName, String lastName, Role role, State state) {
        super(id);
        this.login = login;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.state = state;
    }

    @Column(name = "login", unique = true)
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "first_name")
    @NotBlank(message = "{User.firstName.NotBlank}")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "role")
    private Role role;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "state")
    private State state;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Token> tokens;


    public static UserDTO from(User user) {
        return UserDTO.builder().id(user.getId()).login(user.getLogin()).firstName(user.getFirstName()).lastName(user.getLastName()).build();
    }

    public static List<UserDTO> from(List<User> users) {
        return users.stream().map(u -> from(u)).collect(Collectors.toList());
    }

    public static User from(UserForm form) {
        return User.builder()
                .login(form.getLogin())
                .password(form.getPassword())
                .firstName(form.getFirstName())
                .lastName(form.getLastName())
                .role(Role.USER)
                .state(State.ACTIVE
                )
                .build();
    }

}
