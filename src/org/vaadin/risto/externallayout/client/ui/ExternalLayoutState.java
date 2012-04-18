package org.vaadin.risto.externallayout.client.ui;

import com.vaadin.terminal.gwt.client.ComponentState;

public class ExternalLayoutState extends ComponentState {

    private static final long serialVersionUID = -8018957206438112286L;

    private String externalComponentId;

    public String getExternalComponentId() {
        return externalComponentId;
    }

    public void setExternalComponentId(String externalComponentId) {
        this.externalComponentId = externalComponentId;
    }
}
