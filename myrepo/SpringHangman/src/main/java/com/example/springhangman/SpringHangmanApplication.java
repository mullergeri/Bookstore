package com.example.springhangman;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;

@SpringBootApplication

public class SpringHangmanApplication {


    public static void main(String[] args) throws FileNotFoundException {






            SpringApplication.run(SpringHangmanApplication.class, args);


    }


}
