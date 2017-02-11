package app.config;

import app.service.SmallService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import java.util.Properties;

//Ta annotacja oznacza że z tej klasy będą pochodziły definicje bean-ów w systemie
@Configuration
//Ta annotacja oznacza, że dodatkowe definicje bean-ów będą wciągnięte z podanego file'a typu .xml
@ImportResource("classpath:wsiz-config/our-config.xml")
public class SmallConfig {

    //Bean klasy Properties (java.util.Properties), o nazwie (id) "ustawienia"
    @Bean
    public Properties ustawienia() {
        Properties p = new Properties();
        p.put("user", "admin");
        p.put("pass", "tajne");
        p.put("db_ip", "10.11.12.13");
        return p;
    }

    @Bean
    public SmallService smallService() {
        return new SmallService();
    }
}
