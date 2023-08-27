package app.config;

import static org.javalite.app_config.AppConfig.p;

public class ApplicationConfig {

    public static String getLoginTokenCookieName() {
        return p(ConfigKey.LOGIN_TOKEN_COOKIE_NAME);
    }

    public static String getLoginTokenPublicKeyPath() {
        return p(ConfigKey.LOGIN_TOKEN_PUBLIC_KEY_PATH);
    }

    public static String getLoginTokenPrivateKeyPath() {
        return p(ConfigKey.LOGIN_TOKEN_PRIVATE_KEY_PATH);
    }

}
