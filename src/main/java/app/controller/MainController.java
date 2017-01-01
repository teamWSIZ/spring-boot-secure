package app.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@Slf4j
public class MainController {
    @Value("${admin.pass}")
    String pass;

    @Autowired
    Random mrandom;


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


}
