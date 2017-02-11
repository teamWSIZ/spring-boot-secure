package app.config;

import app.web.CorsFilter;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.servlet.Filter;

//Konfiguracja dla "Application.java", czyli czegoś wystawiającego kontroler https
@Configuration
@Import(SmallConfig.class)
public class AppConfig extends WebMvcAutoConfiguration {

    //Bean klasy Filter (javax.servlet.Filter), o id="corsConfigurer"
    @Bean
    public Filter corsConfigurer() {
        return new CorsFilter();
    }



}
