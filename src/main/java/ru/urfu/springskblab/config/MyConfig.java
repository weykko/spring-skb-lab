package ru.urfu.springskblab.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Slf4j
@Configuration
public class MyConfig {

    @Bean
    @Profile("test")
    public String onlyTestProfile() {
        log.info("Создан бин onlyTestProfile");
        return "";
    }

    @Bean
    @ConditionalOnBean(name = "onlyTestProfile")
    public String existOnlyTestProfile() {
        log.info("Создан бин existOnlyTestProfile");
        return "";
    }

    @Bean
    @ConditionalOnExpression("#{'${env.variable}' != 'default'}")
    public String specialVariable() {
        log.info("Создан бин specialVariable");
        return "";
    }

}
