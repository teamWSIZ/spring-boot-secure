package app.config;
import app.web.CorsFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.security.SecureRandom;
import java.util.Random;

@Configuration
public class AppConfig {

    @Bean
    public Filter corsConfigurer() {
        return new CorsFilter();
    }

    @Bean
    public Random mrandom() {
        return new SecureRandom();
    }

}
