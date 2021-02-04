package gateway;

import org.junit.jupiter.api.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

@WebAppConfiguration
@ContextConfiguration(classes = GatewayApp.class)
public class GatewayAppTest {
    @Test
    public void contextLoads() {

    }
}
