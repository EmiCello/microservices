package user;

import org.junit.jupiter.api.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

@WebAppConfiguration
@ContextConfiguration(classes = UserApp.class)
public class UserAppTest {

    @Test
    public void contextLoads() {

    }
}
