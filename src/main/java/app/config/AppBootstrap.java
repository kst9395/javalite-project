package app.config;

import app.auth.AuthModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.javalite.activeweb.AppContext;
import org.javalite.activeweb.Bootstrap;
import org.javalite.common.Util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import static org.javalite.app_config.AppConfig.p;

public class AppBootstrap extends Bootstrap {

    private PublicKey publicKey;

    private PrivateKey privateKey;

    @Override
    public void init(AppContext appContext) {

        try {
            String loginTokenPublicKeyPath = p(ConfigKey.LOGIN_TOKEN_PUBLIC_KEY_PATH);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            String pubKey = Files.readString(Paths.get(loginTokenPublicKeyPath))
                    .replace("-----BEGIN PUBLIC KEY-----", "")
                    .replaceAll(System.lineSeparator(), "")
                    .replace("-----END PUBLIC KEY-----", "");

            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(Util.fromBase64(pubKey));
            PublicKey publicKey = keyFactory.generatePublic(keySpec);
            this.publicKey = publicKey;
            appContext.set("login_token_public_key", publicKey);

            String loginTokenPrivateKeyPath = p(ConfigKey.LOGIN_TOKEN_PRIVATE_KEY_PATH);

            String privKey = Files.readString(Paths.get(loginTokenPrivateKeyPath))
                    .replace("-----BEGIN PRIVATE KEY-----", "")
                    .replaceAll(System.lineSeparator(), "")
                    .replace("-----END PRIVATE KEY-----", "");

            PKCS8EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(Util.fromBase64(privKey));
            this.privateKey = keyFactory.generatePrivate(privateKeySpec);


        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InvalidKeySpecException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Injector getInjector() {

        return Guice.createInjector(new AuthModule(publicKey, privateKey));
    }
}
