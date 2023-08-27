package app.auth;

import com.google.inject.AbstractModule;

import java.security.PrivateKey;
import java.security.PublicKey;

public class AuthModule extends AbstractModule {

    private PublicKey publicKey;

    private PrivateKey privateKey;

    public AuthModule(PublicKey publicKey, PrivateKey privateKey) {
        this.privateKey = privateKey;
        this.publicKey = publicKey;
    }

    @Override
    protected void configure() {
        bind(TokenService.class).toInstance(new DefaultTokenServiceImpl(publicKey, privateKey));
    }
}
