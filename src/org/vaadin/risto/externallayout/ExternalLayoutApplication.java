package org.vaadin.risto.externallayout;

import com.vaadin.Application;
import com.vaadin.ui.Label;
import com.vaadin.ui.Window;

public class ExternalLayoutApplication extends Application {

    private static final long serialVersionUID = -5256407863468847418L;

    @Override
    public void init() {
        Window mainWindow = new Window("Externallayout Application");
        Label internalLabel = new Label("Internal Label");
        Label externalLabel = new Label("External Label");
        ExternalLayout el = new ExternalLayout("external", externalLabel);
        mainWindow.addComponent(internalLabel);
        mainWindow.addComponent(el);
        setMainWindow(mainWindow);
    }
}
