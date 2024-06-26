
package LoginAndRegistrationPortal;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 *
 * @author lab_services_student
 */
public class LoginAndRegistrationPortalTest {
    
    public LoginAndRegistrationPortalTest() {
    }
    
    @Test
    public void testCheckUserNameValid() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Method method = LoginAndRegistrationPortal.class.getDeclaredMethod("checkUserName", String.class);
        method.setAccessible(true);
        assertTrue((boolean) method.invoke(null, "kyl_1"));
    }

    @Test
    public void testCheckUserNameInvalid() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Method method = LoginAndRegistrationPortal.class.getDeclaredMethod("checkUserName", String.class);
        method.setAccessible(true);
        assertFalse((boolean) method.invoke(null, "kyle!!!!!!!"));
        assertFalse((boolean) method.invoke(null, "kyle"));
    }

    @Test
    public void testCheckPasswordComplexityValid() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Method method = LoginAndRegistrationPortal.class.getDeclaredMethod("checkPasswordComplexity", String.class);
        method.setAccessible(true);
        assertTrue((boolean) method.invoke(null, "Ch&&sec@ke99!"));
    }

    @Test
    public void testCheckPasswordComplexityInvalid() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Method method = LoginAndRegistrationPortal.class.getDeclaredMethod("checkPasswordComplexity", String.class);
        method.setAccessible(true);
        assertFalse((boolean) method.invoke(null, "password"));
        assertFalse((boolean) method.invoke(null, "Passw0rd"));
        assertFalse((boolean) method.invoke(null, "P@ssword"));
        assertFalse((boolean) method.invoke(null, "Passw0rd!"));
    }
}