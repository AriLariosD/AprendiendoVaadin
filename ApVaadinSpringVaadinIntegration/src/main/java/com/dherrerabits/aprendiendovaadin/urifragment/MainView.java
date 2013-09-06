package com.dherrerabits.aprendiendovaadin.urifragment;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import ru.xpoft.vaadin.VaadinView;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.ExternalResource;
import com.vaadin.ui.Link;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
@Component
@Scope("prototype")
@VaadinView(MyVaadinUI.MAINVIEW)
public class MainView extends VerticalLayout implements View {

	@Autowired
	HelloService helloService;
	
	@PostConstruct
	public void PostConstruct() {
		setSizeFull();
		addComponent(new Link("Ir a la vista inicial (StartView)", new ExternalResource("#!" + MyVaadinUI.STARTVIEW)));
	}
	
	@Override
	public void enter(ViewChangeEvent event) {
		Notification.show(helloService.sayHello(this));
	}
}
