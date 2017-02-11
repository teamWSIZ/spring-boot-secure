package app;

import app.config.AppConfig;
import app.config.SmallConfig;
import app.model.AppItem;
import app.service.MultService;
import app.service.SmallService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Properties;

public class OfflineStart {
    public static void main(String[] args) {
        //Uruchamianie spring-a bazując na konfiguracji z pliku SmallConfig.class
        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(SmallConfig.class);

        //Możnaby też:
//        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("wsiz-config/our-config.xml");

//        AppItem item = ctx.getBean(AppItem.class);
//        System.out.println(item);

        Properties p = ctx.getBean("ustawienia", Properties.class);
        System.out.println("########################----->" + p.getProperty("user"));

        SmallService ss = ctx.getBean(SmallService.class);
        System.out.println(ss.addNumbers(10, 12));
        System.out.println(ss.daneDoBazy());

        System.out.println("---------------------------------------");
        MultService ms = ctx.getBean(MultService.class);
        System.out.println(ms.squareDiff(4,2));

        ctx.close();
    }
}
