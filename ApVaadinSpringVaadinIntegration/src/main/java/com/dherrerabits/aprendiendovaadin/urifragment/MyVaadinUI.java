package com.dherrerabits.aprendiendovaadin.urifragment;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import ru.xpoft.vaadin.DiscoveryNavigator;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;
  
@SuppressWarnings("serial")
@Component("MyVaadinUI")
@Scope("prototype")
public class MyVaadinUI extends UI {
	
	DiscoveryNavigator navigator;
	protected static final String STARTVIEW = "";
    protected static final String MAINVIEW = "main";  

    @Override
    protected void init(VaadinRequest request) {
    	
        getPage().setTitle("Ejemplo de navegación");
        
        navigator = new DiscoveryNavigator(this, this);
        
    }
    
}
