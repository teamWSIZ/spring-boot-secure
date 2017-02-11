package app.controller;


import app.model.AppItem;
import app.service.MultService;
import app.service.SmallService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Slf4j
@RestController
@CrossOrigin
@ManagedResource
public class MainController {
    @Value("${admin.pass}")
    String pass;

    @Autowired
    SmallService smallService;

    @Autowired
    MultService multService;

    @ManagedOperation(description = "abra kadabra")
    public String printAbra() {
        return "Abra kadabra";
    }


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

    @RequestMapping(value = "/mult", method = RequestMethod.GET)
    public String help(
            @RequestParam(value = "a", defaultValue = "0") Integer a,
            @RequestParam(value = "b", defaultValue = "0") Integer b
            ) {
        return "" + multService.squareDiff(a, b);
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
