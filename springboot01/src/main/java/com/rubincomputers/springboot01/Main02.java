package com.rubincomputers.springboot01;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class Main02 {
    public static void main(String[] args){

        //throw new ArrayIndexOutOfBoundsException();


//        try {
//            m1();
//        } catch (Exception e){
//
//        }

        m2();


    }

    public static void m1() throws Exception{
        throw new Exception("bla1");
    }

    public static void m2(){
        throw new UsernameNotFoundException("aaa");
    }
}
