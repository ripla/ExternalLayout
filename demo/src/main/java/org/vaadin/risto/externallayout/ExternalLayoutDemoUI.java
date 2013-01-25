package org.vaadin.risto.externallayout;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class ExternalLayoutDemoUI extends UI {

    private static final long serialVersionUID = -5256407863468847418L;

    @Override
    protected void init(VaadinRequest request) {
        VerticalLayout content = new VerticalLayout();
        setContent(content);
        Label internalLabel = new Label("Internal Label");
        Label externalLabel = new Label("External Label");
        ExternalLayout el = new ExternalLayout("external", externalLabel);
        content.addComponent(internalLabel);
        content.addComponent(el);
    }
}
