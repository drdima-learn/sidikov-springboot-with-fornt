package com.rubincomputers.springboot01.service;



import com.rubincomputers.springboot01.dto.TokenDTO;
import com.rubincomputers.springboot01.form.UserForm;
import com.rubincomputers.springboot01.model.Token;
import com.rubincomputers.springboot01.model.User;
import com.rubincomputers.springboot01.repository.TokenRepository;
import com.rubincomputers.springboot01.repository.UserRepository;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class LoginService {

    @Autowired
    private TokenRepository tokenRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    public TokenDTO login(UserForm userForm) {
        Optional<User> userCantidate = userRepository.findOneByLogin(userForm.getLogin());
        if (userCantidate.isPresent()) {
            User user = userCantidate.get();

            if (passwordEncoder.matches(userForm.getPassword(), user.getPassword())) {
                Token token = Token.builder()
                        .user(user)
                        .value(RandomStringUtils.random(10, true, true))
                        .build();
                tokenRepository.save(token);
                return TokenDTO.from(token);
            }
        }
        throw new IllegalArgumentException("user not found");

    }
}
