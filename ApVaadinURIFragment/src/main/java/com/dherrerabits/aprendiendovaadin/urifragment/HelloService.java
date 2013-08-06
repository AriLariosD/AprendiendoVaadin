package com.dherrerabits.aprendiendovaadin.urifragment;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.dherrerabits.aprendiendovaadin.urifragment.MyVaadinUI.MainView;
import com.dherrerabits.aprendiendovaadin.urifragment.MyVaadinUI.StartView;
  
@Service
@Scope("prototype")
public class HelloService {
  
    public String sayHello(Object c) {
    	if (c instanceof StartView)
    		return "Bienvenido a la vista inicial (StartView)";
    	else if (c instanceof MainView)
    		return "Bienvenido a la vista principal (MainView)";
    	else
    		return "Hola desde servicio Spring!!!";
    }
}
