package org.vaadin.risto.externallayout.client.ui;

import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.SimplePanel;
import com.vaadin.terminal.gwt.client.ComponentConnector;
import com.vaadin.terminal.gwt.client.ConnectorHierarchyChangeEvent;
import com.vaadin.terminal.gwt.client.ui.AbstractComponentContainerConnector;
import com.vaadin.terminal.gwt.client.ui.Connect;

@Connect(org.vaadin.risto.externallayout.ExternalLayout.class)
public class VExternalLayoutConnector extends
        AbstractComponentContainerConnector {

    private static final long serialVersionUID = 2272582707865117536L;

    @Override
    protected SimplePanel createWidget() {
        return new VExternalLayout();
    }

    @Override
    public VExternalLayout getWidget() {
        return (VExternalLayout) super.getWidget();
    }

    @Override
    public ExternalLayoutState getState() {
        return (ExternalLayoutState) super.getState();
    }

    @Override
    public void onConnectorHierarchyChange(ConnectorHierarchyChangeEvent event) {
        super.onConnectorHierarchyChange(event);
        ComponentConnector child = getChildren().get(0);

        Element targetElement = DOM.getElementById(getState()
                .getExternalComponentId());
        if (targetElement == null) {
            targetElement = getWidget().getElement();
        }
        getWidget().setRenderTargetElement(targetElement);

        getWidget().setWidget(child.getWidget());
    }

    @Override
    public void updateCaption(ComponentConnector connector) {
        // Captions not supported
    }

}
