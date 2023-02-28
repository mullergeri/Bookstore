package com.example.hellospring;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
//@Scope("prototype")
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Az {

    String name;

}
