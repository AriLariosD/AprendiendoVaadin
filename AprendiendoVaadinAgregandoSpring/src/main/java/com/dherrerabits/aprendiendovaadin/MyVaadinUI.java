package com.dherrerabits.aprendiendovaadin;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
  
/**
 * The Application's "main" class
 */
@SuppressWarnings("serial")
public class MyVaadinUI extends UI implements ClickListener{
      
    @Autowired
    HelloService helloService;
  
    @Override
    protected void init(VaadinRequest request) {
        final VerticalLayout layout = new VerticalLayout();
        layout.setMargin(true);
        setContent(layout);
        Button button = new Button("Click Me");
        button.addClickListener((Button.ClickListener) this);
        layout.addComponent(button);
    }
      
    public void buttonClick(ClickEvent event){
        if (helloService != null){
            Notification.show("The injected service says", helloService.sayHello(), Type.HUMANIZED_MESSAGE);
        }
    }
  
}
