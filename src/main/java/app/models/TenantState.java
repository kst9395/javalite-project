package app.models;

import org.javalite.activejdbc.Model;

public class TenantState extends Model {

    static {
        validatePresenceOf("state_key").message("Key is mandatory");
        validatePresenceOf("state_value").message("Value is mandatory");
    }

}
