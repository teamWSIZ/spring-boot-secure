package app.config;
import app.service.UserService;
import app.web.CorsFilter;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import javax.servlet.Filter;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Configuration
public class AppConfig extends WebMvcAutoConfiguration {

    @Bean
    public Filter corsConfigurer() {
        return new CorsFilter();
    }

    @Bean
    UserService userService() {
        return new UserService();
    }

}
