package app.controller;


import app.model.SystemInfo;
import app.model.User;
import app.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class CalcController {

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public Integer addNumbers(@RequestParam("a") Integer a,
                              @RequestParam("b") Integer b) {
        int wynik = a + b;
        return wynik;
    }

}
