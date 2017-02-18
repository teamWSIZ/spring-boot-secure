package app;

import app.config.AppConfig;
import app.config.SmallConfig;
import app.model.AppItem;
import app.model.User;
import app.model.UserRepo;
import app.service.MultService;
import app.service.SmallService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class OfflineStart {
    public static void main(String[] args) throws Exception {
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

        //Test bazy danych
        System.out.println("--------all---------");
        UserRepo repo = ctx.getBean(UserRepo.class);
        for(User u : repo.findAll()) {
            System.out.println(u);
        }
        System.out.println("--------active---------");
        for(User u : repo.getByActiveTrue()) {
            System.out.println(u);
        }
        System.out.println("--------old---------");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        for(User u : repo.getByBirthdateAfter(df.parse("2000-01-01"))) {
            System.out.println(u);
        }
        User nowy;
        nowy = new User(null, "DanielZhang", df.parse("1960-01-01"), true);
        nowy = repo.save(nowy);
        nowy = repo.getByUsername("DanielZhang");
        System.out.println("nowy:" + nowy);
        repo.delete(nowy);
//        System.out.println("nowy:" + nowy);

        System.out.println("------------------");

        //Sprawdzanie funkcji szukania userów po dacie urodzenia
        for(User u : repo.getByBirthdate(df.parse("2000-02-01"))) {
            System.out.println("###->" + u);
        }


        ctx.close();
    }
}
