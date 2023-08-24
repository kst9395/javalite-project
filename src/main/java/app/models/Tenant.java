package app.models;

import org.javalite.activejdbc.Model;

public class Tenant extends Model {
    static {
        validatePresenceOf("tenant_name").message("Name is mandatory");
    }
}
