package com.dherrerabits.aprendiendovaadin;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
  
@Service
@Scope("prototype")
public class HelloService {
  
    public String sayHello() {
        return "Hello Vaadiners from a Spring Service!!!";
    }
}
