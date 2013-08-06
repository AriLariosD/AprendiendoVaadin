package com.dherrerabits.aprendiendovaadin.urifragment;

import com.vaadin.server.UIClassSelectionEvent;
import com.vaadin.server.UICreateEvent;
import com.vaadin.server.UIProvider;
import com.vaadin.ui.UI;
  
@SuppressWarnings("serial")
public class MyUIProvider extends UIProvider {
  
    @SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
    public Class getUIClass(UIClassSelectionEvent event) {
        return MyVaadinUI.class;
    }
  
    @Override
    public UI createInstance(UICreateEvent event) {
        UI instance = super.createInstance(event);
        Inject.inject(instance);
        return instance;
    }
}
