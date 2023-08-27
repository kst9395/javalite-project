package app.auth;

public interface TokenService {

    boolean verifyToken(String token) throws Exception;

    String generateToken(TokenPayload tokenPayload) throws Exception;


}
