package com.rubincomputers.springboot01;

import com.rubincomputers.springboot01.config.AppConfig;
import com.rubincomputers.springboot01.model.Role;
import com.rubincomputers.springboot01.model.State;
import com.rubincomputers.springboot01.model.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Locale;
import java.util.Set;

public class Main01 {
    public static void main(String[] args) {

        Locale.setDefault(new Locale("ru"));

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);


//        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
//        Validator validator = validatorFactory.getValidator();
//
//        Set<ConstraintViolation<User>> violations = validator.validate(new User(1L, "vvv", "loginov", "", "Pupkin"));
//        System.out.println(violations);

        Validator validator = context.getBean(Validator.class);
        Set<ConstraintViolation<User>> violations = validator.validate(new User(1L, "vvv", "loginov", "", "Pupkin", Role.USER, State.ACTIVE));

        for (ConstraintViolation<User> violation : violations) {
            String fieldName = violation.getPropertyPath().toString();
            String message = violation.getMessage();

            System.out.println(fieldName + ": " + message);
        }


        context.close();
    }
}
