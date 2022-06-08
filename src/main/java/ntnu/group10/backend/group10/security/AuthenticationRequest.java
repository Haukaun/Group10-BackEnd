package ntnu.group10.backend.group10.security;

/**
 * Code from GitHub:
 * https://github.com/strazdinsg/app-dev/tree/main/security-demos/05-jwt-authentication/src/main/java/no/ntnu/security
 * Data that the user will send in the login request.
 */
public class AuthenticationRequest {
    private String userName;
    private String password;

    /**
     * Instantiates a new Authentication request.
     */
    public AuthenticationRequest() {

    }

    /**
     * Instantiates a new Authentication request.
     *
     * @param userName the user name
     * @param password the password
     */
    public AuthenticationRequest(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    /**
     * Gets user name.
     *
     * @return the user name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets user name.
     *
     * @param userName the user name
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Gets password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets password.
     *
     * @param password the password
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
