package ntnu.group10.backend.group10.security;

/**
 * Code from GitHub:
 * https://github.com/strazdinsg/app-dev/tree/main/security-demos/05-jwt-authentication/src/main/java/no/ntnu/security
 * Data that we will send as a response to the user when the authentication is successful.
 */
public class AuthenticationResponse {
    private final String jwt;



    /**
     * Instantiates a new Authentication response.
     *
     * @param jwt the jwt
     */
    public AuthenticationResponse(String jwt) {
        this.jwt = jwt;
    }

    /**
     * Gets jwt token.
     *
     * @return the jwt
     */
    public String getJwt() {
        return jwt;
    }
}
