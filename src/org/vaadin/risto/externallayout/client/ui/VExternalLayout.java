package org.vaadin.risto.externallayout.client.ui;

import java.util.Set;

import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.vaadin.terminal.gwt.client.ApplicationConnection;
import com.vaadin.terminal.gwt.client.Container;
import com.vaadin.terminal.gwt.client.Paintable;
import com.vaadin.terminal.gwt.client.RenderSpace;
import com.vaadin.terminal.gwt.client.UIDL;

public class VExternalLayout extends SimplePanel implements Container {

    public static final String ATTR_DIVID = "divid";
    private static final String CLASSNAME = "v-externallayout";
    private ApplicationConnection client;

    private Paintable childPaintable;
    private String divId;
    private Element renderTargetElement;

    public VExternalLayout() {
        super();
        renderTargetElement = getElement();
    }

    /**
     * @post renderTargetElement is != null and valid
     */
    public void updateFromUIDL(UIDL uidl, ApplicationConnection client) {
        this.client = client;

        if (client.updateComponent(this, uidl, false)) {
            return;
        }

        if (uidl.hasAttribute(ATTR_DIVID) && divId == null) {
            divId = uidl.getStringAttribute(ATTR_DIVID);
            Element targetElement = DOM.getElementById(divId);

            // externalElement is either getElement() or some other specified
            // element
            renderTargetElement = targetElement == null ? getElement()
                    : targetElement;

            DOM.setElementProperty(renderTargetElement, "className", CLASSNAME);
        }

        final UIDL childUIDL = uidl.getChildUIDL(0);

        Paintable newPaintable = null;

        if (childUIDL != null) {
            newPaintable = client.getPaintable(childUIDL);
            if (!hasChildComponent((Widget) newPaintable)) {
                replaceChildComponent((Widget) childPaintable,
                        (Widget) newPaintable);
            }

        }

        if (childPaintable != null) {
            childPaintable.updateFromUIDL(childUIDL, client);
        }

    }

    public RenderSpace getAllocatedSpace(Widget child) {
        return new RenderSpace(renderTargetElement.getOffsetWidth(),
                renderTargetElement.getOffsetHeight());
    }

    public boolean hasChildComponent(Widget component) {
        return component == childPaintable;
    }

    public void replaceChildComponent(Widget oldComponent, Widget newComponent) {
        if (oldComponent != null) {
            client.unregisterPaintable((Paintable) getWidget());
            this.clear();
        }

        setWidget(newComponent);
    }

    public boolean requestLayout(Set<Paintable> children) {
        return renderTargetElement == getElement();
    }

    public void updateCaption(Paintable component, UIDL uidl) {
        // NOOP
    }

    public void setWidget(Widget w) {
        super.setWidget(w);
        childPaintable = (Paintable) w;
    }

    /**
     * This is overridden so that {@link #setWidget(Widget)} uses the specified
     * external element.
     */
    protected Element getContainerElement() {
        return renderTargetElement;
    }

}
