package ru.urfu.springskblab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import ru.urfu.springskblab.config.ConfigProps;

@EnableConfigurationProperties(ConfigProps.class)
@SpringBootApplication
public class SpringSkbLabApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSkbLabApplication.class, args);
    }

}
