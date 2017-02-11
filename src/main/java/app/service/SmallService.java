package app.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.HashMap;
import java.util.Properties;

@Slf4j
public class SmallService {

    @Autowired
    HashMap mapa;

    @Autowired
    @Qualifier("ustawienia")
    Properties properties;

    public int addNumbers(int a, int b) {
        log.info("Mnożę liczby: [{}] [{}]", a, b);
        return a + b;
    }

    public String daneDoBazy() {
        return properties.getProperty("user") + ":" + properties.getProperty("pass");
    }


}
