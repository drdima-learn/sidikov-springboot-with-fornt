package com.rubincomputers.springboot01;

import com.rubincomputers.springboot01.model.User;
import com.rubincomputers.springboot01.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import javax.sql.DataSource;

/**
 * Hello world!
 */
@SpringBootApplication
public class App {




    @Autowired
    UserRepository repository;

    public static void main(String[] args) {
        System.out.println("Hello World!");


        SpringApplication.run(App.class, args);
    }


}
