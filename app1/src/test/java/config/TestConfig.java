package config;

import app1.dal.UserDalImpl;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class TestConfig {
    @Bean
    public UserDalImpl getUserDalImpl() {
        return new UserDalImpl();
    }
}
