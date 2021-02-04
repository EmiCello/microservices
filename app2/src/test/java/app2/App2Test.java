package app2;

import org.junit.jupiter.api.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

@WebAppConfiguration
@ContextConfiguration(classes = App2.class)
public class App2Test {

    @Test
    public void contextLoads() {

    }
}

