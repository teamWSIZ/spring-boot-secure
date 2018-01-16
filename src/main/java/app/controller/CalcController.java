package app.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalcController {

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public Integer addNumbers(@RequestParam("a") Integer a,
                              @RequestParam("b") Integer b) {
        int wynik = a + b;
        return wynik;
    }

}
