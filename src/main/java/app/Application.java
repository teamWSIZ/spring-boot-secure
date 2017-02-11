package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Aplikacja startująca serwer https, i wszystkie bean-y systemu
 */

//To jest kobyła która chodzi po pakietach `config` i `service` i wciąga wszystkie file oznaczone jako @Configuration
@SpringBootApplication(scanBasePackages = {"config","service"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
