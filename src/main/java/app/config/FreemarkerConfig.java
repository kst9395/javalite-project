package app.config;

import org.javalite.activeweb.freemarker.AbstractFreeMarkerConfig;

public class FreemarkerConfig extends AbstractFreeMarkerConfig {
    @Override
    public void init() {
        getConfiguration().setNumberFormat("0.##");
    }
}
