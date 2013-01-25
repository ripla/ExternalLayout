package org.vaadin.risto.externallayout.client.ui;

import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;

public class VExternalLayout extends SimplePanel implements Iterable<Widget> {

    private static final String CLASSNAME = "v-externallayout";

    private Element renderTargetElement;

    public VExternalLayout() {
        renderTargetElement = getElement();
    }

    /**
     * This is overridden so that {@link #setWidget(Widget)} uses the specified
     * external element.
     */
    @Override
    protected Element getContainerElement() {
        return getRenderTargetElement();
    }

    public Element getRenderTargetElement() {
        return renderTargetElement;
    }

    public void setRenderTargetElement(Element renderTargetElement) {
        this.renderTargetElement = renderTargetElement;
        DOM.setElementProperty(renderTargetElement, "className", CLASSNAME);
    }

}
