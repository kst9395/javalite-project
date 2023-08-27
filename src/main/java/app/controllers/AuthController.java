package app.controllers;

import org.javalite.activeweb.AppController;
import org.javalite.activeweb.annotations.POST;

public class AuthController extends AppController {

    @POST
    public void login() {

    }

    public void index(){
        render().noLayout();
    }
}
