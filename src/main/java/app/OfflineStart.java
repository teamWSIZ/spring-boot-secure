package app;

import app.config.AppConfig;
import app.config.SmallConfig;
import app.model.AppItem;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class OfflineStart {
    public static void main(String[] args) {
        //Uruchamianie spring-a bazując na konfiguracji z pliku SmallConfig.class
        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(SmallConfig.class);

        //Możnaby też:
//        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("wsiz-config/our-config.xml");

        AppItem item = ctx.getBean(AppItem.class);
        System.out.println(item);
    }
}
