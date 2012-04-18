package org.vaadin.risto.externallayout;

import com.vaadin.terminal.WrappedRequest;
import com.vaadin.ui.Label;
import com.vaadin.ui.Root;

public class ExternalLayoutDemoRoot extends Root {

    private static final long serialVersionUID = -5256407863468847418L;

    @Override
    protected void init(WrappedRequest request) {
        Label internalLabel = new Label("Internal Label");
        Label externalLabel = new Label("External Label");
        ExternalLayout el = new ExternalLayout("external", externalLabel);
        addComponent(internalLabel);
        addComponent(el);
    }
}
