package app.config;

import app.controllers.RequireLoginFilter;
import org.javalite.activeweb.AbstractControllerConfig;
import org.javalite.activeweb.AppContext;
import org.javalite.activeweb.controller_filters.DBConnectionFilter;

public class AppControllerConfig extends AbstractControllerConfig {
    @Override
    public void init(AppContext appContext) {

        add(new DBConnectionFilter(), new RequireLoginFilter());
    }
}
