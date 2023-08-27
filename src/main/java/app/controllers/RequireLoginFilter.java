package app.controllers;

import app.config.ConfigKey;
import org.javalite.activeweb.controller_filters.AppControllerFilter;
import org.javalite.common.Util;

import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;

import static org.javalite.app_config.AppConfig.p;

public class RequireLoginFilter extends AppControllerFilter {


    private boolean isLoggedIn() throws NoSuchAlgorithmException {
        final String loginTokenCookieName = p(ConfigKey.LOGIN_TOKEN_COOKIE_NAME);
        String loginToken = cookieValue(loginTokenCookieName);
        if (Util.blank(loginToken)) {
            return false;
        }
        PublicKey publicKey = appContext().get("login_token_public_key", PublicKey.class);
        Signature.getInstance("");
        return false;
    }

    @Override
    public void before() {

        if (getRoute().getController().getClass().isAnnotationPresent(RequireLogin.class) || getRoute().getActionMethod().isAnnotationPresent(RequireLogin.class)) {

        }
    }
}
