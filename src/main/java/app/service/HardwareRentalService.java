package app.service;


import app.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Serwis zarządzający systemem wyporzyczania sprzętu firmowego.
 */
public class HardwareRentalService {
    @Autowired
    UserService userService;


    public void checkWhoRented(Integer hardwareId) {
        List<User> allUsers = userService.getAll();
        //... todo
    }

}
