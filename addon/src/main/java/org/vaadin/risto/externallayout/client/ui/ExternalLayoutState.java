package org.vaadin.risto.externallayout.client.ui;

import com.vaadin.shared.AbstractComponentState;

public class ExternalLayoutState extends AbstractComponentState {

    private static final long serialVersionUID = -8018957206438112286L;

    private String externalComponentId;

    public String getExternalComponentId() {
        return externalComponentId;
    }

    public void setExternalComponentId(String externalComponentId) {
        this.externalComponentId = externalComponentId;
    }
}
