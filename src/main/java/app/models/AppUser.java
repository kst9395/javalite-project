package app.models;

import org.javalite.activejdbc.Model;

public class AppUser extends Model {

    static {
        validatePresenceOf("username").message("Username is mandatory");
        validatePresenceOf("password").message("Password is mandatory");
        validatePresenceOf("first_name").message("First name is mandatory");
        validatePresenceOf("last_name").message("Last name is mandatory");
    }



}
