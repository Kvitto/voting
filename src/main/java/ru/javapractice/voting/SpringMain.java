package ru.javapractice.voting;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class SpringMain {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-app.xml");
        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

        context.close();
    }
}
