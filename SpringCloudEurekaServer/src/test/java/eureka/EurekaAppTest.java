package eureka;

import org.junit.jupiter.api.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

@WebAppConfiguration
@ContextConfiguration(classes = EurekaApp.class)
public class EurekaAppTest {

    @Test
    public void contextLoads() {

    }
}
