package com.example.hellospring;

import org.springframework.stereotype.Component;

@Component
public interface Impl {

    default String getName() {
        return  this.getClass().toString();
    }
}
