package org.vaadin.risto.externallayout;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

import javax.servlet.annotation.WebServlet;

@Theme(ValoTheme.THEME_NAME)
public class ExternalLayoutDemoUI extends UI {

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

    @WebServlet(urlPatterns = {"/ExternalLayout/*", "/VAADIN/*"})
    @VaadinServletConfiguration(ui = ExternalLayoutDemoUI.class, productionMode = false, widgetset = "org.vaadin.risto.externallayout.widgetset.ExternalLayoutDemoWidgetset")
    public static class ExternalLayoutDemoServlet extends VaadinServlet {

    }
}
