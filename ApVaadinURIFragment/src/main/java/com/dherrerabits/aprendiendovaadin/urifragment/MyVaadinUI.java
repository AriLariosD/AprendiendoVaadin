package com.dherrerabits.aprendiendovaadin.urifragment;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
  
/**
 * The Application's "main" class
 */
@SuppressWarnings("serial")
public class MyVaadinUI extends UI {
      
	@Autowired
    HelloService helloService;
	
    Navigator navigator;
    protected static final String MAINVIEW = "main";

    @Override
    protected void init(VaadinRequest request) {
    	
        getPage().setTitle("Ejemplo de navegación");
        
        // Crear un navegador para controlar las Vistas
        navigator = new Navigator(this, this);
        
        // Crear y registrar las Vistas
        navigator.addView("", new StartView());
        navigator.addView(MAINVIEW, new MainView());
        
    }
  
    public class StartView extends VerticalLayout implements View,ClickListener {
    	
    	public StartView() {
    		
            setSizeFull();
            Button button = new Button("Ir a la vista principal (MainView)");
            button.addClickListener((Button.ClickListener) this);
            addComponent(button);
            setComponentAlignment(button, Alignment.TOP_LEFT);
            
        }
    	
    	@Override
    	public void enter(ViewChangeEvent event) {
    		Notification.show(helloService.sayHello(this));
    	}

    	@Override
    	public void buttonClick(ClickEvent event) {
    		navigator.navigateTo(MAINVIEW);
    	}

    }

    public class MainView extends VerticalLayout implements View,ClickListener {

    	public MainView() {
    		
            setSizeFull();
            Button button = new Button("Ir a la vista inicial (StartView)");
            button.addClickListener((Button.ClickListener) this);
            addComponent(button);
            setComponentAlignment(button, Alignment.TOP_LEFT);
            
        }
    	
    	@Override
    	public void enter(ViewChangeEvent event) {
    		Notification.show(helloService.sayHello(this));
    	}

    	@Override
    	public void buttonClick(ClickEvent event) {
    		navigator.navigateTo("");
    	}

    }

    
}
