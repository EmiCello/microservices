package app1;

import org.junit.jupiter.api.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

@WebAppConfiguration
@ContextConfiguration(classes = App1.class)
public class App1Test {

    @Test
    public void contextLoads() {

    }
}
