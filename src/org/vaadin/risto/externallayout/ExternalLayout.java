package org.vaadin.risto.externallayout;

import java.util.Collections;
import java.util.Iterator;

import org.vaadin.risto.externallayout.client.ui.VExternalLayout;

import com.vaadin.terminal.PaintException;
import com.vaadin.terminal.PaintTarget;
import com.vaadin.ui.AbstractComponentContainer;
import com.vaadin.ui.Component;

/**
 * Single component layout that can render the given component on any HTML
 * element.
 * 
 * @author Risto Yrjänä / Vaadin Ltd.
 */
@SuppressWarnings("serial")
@com.vaadin.ui.ClientWidget(org.vaadin.risto.externallayout.client.ui.VExternalLayout.class)
public class ExternalLayout extends AbstractComponentContainer {

    private String divId;
    private Component childComponent;

    /**
     * Create a layout that renders the given component to a HTML element that
     * has the specified id
     * 
     * @param divId
     *            target id for the component, cannot be null
     * @param component
     *            component to be rendered, cannot be null
     */
    public ExternalLayout(String divId, Component component) {
        if (divId == null || component == null) {
            throw new IllegalArgumentException(
                    "The div id or the child component cannot be null.");
        }

        this.divId = divId;
        childComponent = component;
        super.addComponent(childComponent);
    }

    @Override
    public void paintContent(PaintTarget target) throws PaintException {
        super.paintContent(target);

        childComponent.paint(target);
        target.addAttribute(VExternalLayout.ATTR_DIVID, divId);
    }

    @Override
    public void replaceComponent(Component oldComponent, Component newComponent) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<Component> getComponentIterator() {
        return Collections.singleton(childComponent).iterator();
    }

}
