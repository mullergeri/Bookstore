package com.example.hellospring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class Main {


    @Autowired
    private Impl inner;


    private String appName;
    private String version;


    public Main(Impl i) {

        this.inner = i;

    }

    @EventListener(ApplicationReadyEvent.class)
    public void start() {
        System.out.println("Hello Spring!");
/*
        System.out.println(az2.name);
        az2.name = "Kacsika";
        System.out.println(az2.name);
        System.out.println(az1.name);
        az1.name = "Lajos";
        System.out.println(az1.name);
      */
        System.out.println(this.appName);
        System.out.println(this.version);

        System.out.println(inner);

    }




    @Autowired
    private void injectValue(
            @Value("${app.name}") String name,
            @Value("${app.version}") String version) {
        this.appName = name;
        this.version = version;

    }

}
