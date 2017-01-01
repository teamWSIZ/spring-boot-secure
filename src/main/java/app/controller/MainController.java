package app.controller;


import lombok.Builder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

@RestController
public class MainController {
    @Value("${admin.pass}")
    String pass;

    public MainController() {

    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String help(@RequestParam(value = "pass", defaultValue = "") String cpass) {
        if (!pass.equals(cpass)) return "";
        return "OK";
    }

    @RequestMapping(value = "/start-tomcat", method = RequestMethod.GET)
    public String startTomcat() {
        System.out.println(pass);
        return "OK";
    }


}
