package ntnu.group10.backend.group10.security;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

public class PasswordEncoder {
    Argon2 argon2 = Argon2Factory.create();

    public String encrypt(String passwdInput){
        //check if password is complex enough
        return argon2.hash(22, 65536, 1, passwdInput);
    }

}