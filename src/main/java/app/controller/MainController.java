package app.controller;


import app.model.AppItem;
import app.service.Integrator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Slf4j
@RestController
//@EnableWebMvc
public class MainController {
    @Value("${admin.pass}")
    String pass;

    Integrator integrator = new Integrator();

    //some data
    List<AppItem> items = new ArrayList<>();

    public MainController() {
        items.add(new AppItem(1, "Title1", "Body1"));
        items.add(new AppItem(2, "Title2", "Bo2"));
        items.add(new AppItem(3, "Title3", "Bo3"));
        items.add(new AppItem(4, "Title4", "Body4"));
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String help(@RequestParam(value = "pass", defaultValue = "") String cpass) {
        if (!pass.equals(cpass)) return "";
        return "OK";
    }

    @RequestMapping(value = "/start-tomcat", method = RequestMethod.GET)
    public String startTomcat() {
        log.info("Password accessed, is : [{}]", pass);
        return "OK";
    }

    @RequestMapping(value = "/items", method = RequestMethod.GET)
    public List<AppItem> getItems() {
        return items;
    }

    @RequestMapping(value = "/integral", method = RequestMethod.GET)
    public Double computeIntegral(
            @RequestParam(value = "a", defaultValue = "0") double a,
            @RequestParam(value = "b", defaultValue = "3.141592") double b) {
        log.debug("REST integrator called");

        return integrator.integrateMyFunction1(a, b);
    }


    @RequestMapping(value = "/items", method = RequestMethod.POST)
    public AppItem createItem(@RequestBody AppItem item) {
        item.setId(items.size()+1);
        items.add(item);
        return item;
    }



    @RequestMapping(value = "/app")
    public String showWebPage(ModelMap model) {
        return "burak";
    }


}
