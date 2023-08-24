package app.controllers;

import org.javalite.activeweb.controller_filters.AppControllerFilter;
import org.javalite.common.Util;

public class HTMXFilter extends AppControllerFilter {

    @Override
    public void after() {
        if (!Util.blank(header("HX-Request"))) {
            if (getRoute().getActionMethod().isAnnotationPresent(HTMX.class)) {
                HTMX htmx = getRoute().getActionMethod().getAnnotation(HTMX.class);
                render("htmx/"+htmx.value(), values());
            }
        }
    }
}
