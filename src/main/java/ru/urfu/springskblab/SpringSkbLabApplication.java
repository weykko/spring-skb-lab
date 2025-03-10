//package ru.urfu.springskblab;
//
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//@SpringBootApplication
//public class SpringSkbLabApplication {
//
//    public static void main(String[] args) {
//        SpringApplication.run(SpringSkbLabApplication.class, args);
//    }
//
//}

package ru.urfu.springskblab;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringSkbLabApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSkbLabApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(ShoppingCart shoppingCart) {
        return args -> shoppingCart.checkout();
    }
}

