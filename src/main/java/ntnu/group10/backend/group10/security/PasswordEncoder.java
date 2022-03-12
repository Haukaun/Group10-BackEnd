package ntnu.group10.backend.group10.security;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

public class PasswordEncoder {


    public static void main(String[] args) {
        String passwd = "test";
        Argon2 argon2 = Argon2Factory.create();

        String hash = argon2.hash(22, 65536, 1, passwd);
        System.out.println(hash);
    }
}