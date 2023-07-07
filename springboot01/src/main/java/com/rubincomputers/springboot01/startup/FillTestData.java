package com.rubincomputers.springboot01.startup;

import com.rubincomputers.springboot01.model.User;
import com.rubincomputers.springboot01.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


@Component
public class FillTestData  {

    //@Autowired
    //UserRepository repository;



    @PostConstruct
    public void run() {
        //System.out.println("startup");
        //User user = User.builder().id(1L).login("vasya").password("1234").firstName("Vasilii").lastName("Pupkin").build();
        //User user = User.builder().login("vasya").password("1234").firstName("Vasilii").lastName("Pupkin").build();
        //repository.save(user);
    }
}
