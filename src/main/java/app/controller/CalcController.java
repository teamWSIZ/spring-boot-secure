package app.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalcController {

    private static final Logger log = LoggerFactory.getLogger(CalcController.class);


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public Integer addNumbers(@RequestParam("a") Integer a,
                              @RequestParam("b") Integer b) {
        int wynik = a + b;
        return wynik;
    }

    @RequestMapping(value = "/mul", method = RequestMethod.GET)
    public Integer multiplyNumbers(@RequestParam("a") Integer a,
                              @RequestParam("b") Integer b) {
        int wynik = a * b;
        return wynik;
    }

    //todo: można tu wprowadzić własny "ExceptionHandler"
    @RequestMapping(value = "/div", method = RequestMethod.GET)
    public Integer divideNumbers(@RequestParam("a") Integer a,
                                   @RequestParam("b") Integer b) {
        if (b==0) {
            log.warn("Klient żąda dzielenia przez zero!");
            throw new RuntimeException("Dzielenie przez zero");
        }
        int wynik = a / b;
        return wynik;
    }

}
