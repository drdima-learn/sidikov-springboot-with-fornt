package com.rubincomputers.springboot01;

import com.rubincomputers.springboot01.security.filter.TokenAuthFilter;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class Main03 {
    public static void main(String[] args) {

        Class<Main03> main03Class = Main03.class;
        Class<Main03> main03Class2 = Main03.class;
        System.out.println(Main03.class.equals(main03Class));

        System.out.println(main03Class2);

        Main03 main03 = new Main03();

        System.out.println(main03 instanceof Main03);

        TokenAuthFilter filter = new TokenAuthFilter();
    }
}
