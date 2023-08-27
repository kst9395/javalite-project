package app.controllers;

import app.auth.TokenService;
import app.config.ApplicationConfig;
import com.google.inject.Inject;
import org.javalite.activeweb.controller_filters.AppControllerFilter;
import org.javalite.common.Util;

public class RequireLoginFilter extends AppControllerFilter {

    private TokenService tokenService;

    @Inject
    public void setTokenService(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    private boolean isLoggedIn() throws Exception {
        final String loginTokenCookieName = ApplicationConfig.getLoginTokenCookieName();
        String loginToken = cookieValue(loginTokenCookieName);
        if (Util.blank(loginToken)) {
            return false;
        }
        return tokenService.verifyToken(loginToken);
    }

    @Override
    public void before() {
        if (getRoute().getController().getClass().isAnnotationPresent(RequireLogin.class) || getRoute().getActionMethod().isAnnotationPresent(RequireLogin.class)) {
            try {
                if (!isLoggedIn()) {
                    logInfo("Unauthenticated, redirect");
                }
            } catch (Exception e) {
                logError("Error", e);
            }
        }
    }
}
