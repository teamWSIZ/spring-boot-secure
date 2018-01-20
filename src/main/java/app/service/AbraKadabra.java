package app.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component      //ta annotacja powoduje, że serwis zostanie automatycznie wykryty jako "bean" (nie trzeba pisać w AppConfig)
public class AbraKadabra {
    //Serwisy mogą używać siebie nawzajem

    @Autowired
    FileService fileService;

    @Autowired
    UserService userService;

    public String someResponse() {
        return "Some not very revelaring response...";
    }
}
