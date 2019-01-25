package com.nkongara.springbootintro;

import com.nkongara.springbootintro.config.MyAppConfig;
import com.nkongara.springbootintro.config.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class DemoApplication {

    // Beans created here are application scope.
    @Bean
    public User user() {
        return new User("Naga", "Kongara");
    }

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(DemoApplication.class, args);

        System.out.println("Hello from Spring Boot Fundamentals.");

        // To print all the beans created.
        /*String [] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for ( String name : beanNames ){
            System.out.println(name);
        }*/

        System.out.println( ctx.getBean("user").toString() );
        System.out.println(ctx.getBean("datasource").toString());

        MyAppConfig config = (MyAppConfig)  ctx.getBean("myAppConfig");
        System.out.println(config.toString());
    }
}
