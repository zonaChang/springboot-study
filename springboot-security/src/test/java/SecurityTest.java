import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

/**
 * @author changez
 * @desc
 * @datetime 2019/9/14 13:34
 */
public class SecurityTest {

    @Test
    public void  generatePassword(){
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        System.out.println(passwordEncoder.encode("zona-p"));
        System.out.println(passwordEncoder.encode("carl-p"));
        passwordEncoder = new Pbkdf2PasswordEncoder("adf");
        System.out.println(passwordEncoder.encode("zona-p"));
        System.out.println(passwordEncoder.encode("carl-p"));
        System.out.println(passwordEncoder.encode("changez-p1"));

    }
}
