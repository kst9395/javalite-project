package app.auth;

import org.javalite.common.JsonHelper;
import org.javalite.common.Util;

import java.nio.charset.StandardCharsets;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.util.Base64;

public class DefaultTokenServiceImpl implements TokenService {

    private final PublicKey publicKey;

    private final PrivateKey privateKey;

    public DefaultTokenServiceImpl(PublicKey publicKey, PrivateKey privateKey) {
        this.privateKey = privateKey;
        this.publicKey = publicKey;
    }

    @Override
    public boolean verifyToken(String token) throws Exception {
        if (Util.blank(token) || !token.contains(".")) {
            throw new IllegalStateException("Invalid token");
        }
        String[] parts = token.split("\\.");
        if (parts.length != 3) {
            throw new IllegalStateException("Invalid token");
        }

        String inputSignature = parts[2];
        String raw = token.substring(0, token.lastIndexOf("."));
        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initVerify(publicKey);
        signature.update(raw.getBytes(StandardCharsets.UTF_8));
        return signature.verify(Base64.getUrlDecoder().decode(inputSignature));
    }

    @Override
    public String generateToken(TokenPayload payload) throws Exception {
        String format = "%s.%s.%s";
        String encodedHeader = Base64.getUrlEncoder().withoutPadding().encodeToString(JsonHelper.toJsonString(TokenHeader.RS256_HEADER).getBytes(StandardCharsets.UTF_8));
        String encodedPayload = Base64.getUrlEncoder().withoutPadding().encodeToString(JsonHelper.toJsonString(payload).getBytes(StandardCharsets.UTF_8));

        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initSign(this.privateKey);
        signature.update("%s.%s".formatted(encodedHeader, encodedPayload).getBytes(StandardCharsets.UTF_8));
        String encodedSignature = Base64.getUrlEncoder().withoutPadding().encodeToString(signature.sign());


        return format.formatted(encodedHeader, encodedPayload, encodedSignature);
    }
}
