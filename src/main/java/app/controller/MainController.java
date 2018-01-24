package app.controller;


import app.model.SystemInfo;
import app.model.User;
import app.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MainController {

    @Autowired
    UserService userService;

    private static final Logger log = LoggerFactory.getLogger(MainController.class);

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> getUsers() {
        return userService.getAll();
    }


    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public User getUser(
            @PathVariable Integer id) {
        log.debug("Getting details of user with id: {}", id);

        return userService.get(id);
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public User createUser(@RequestBody User user) {
        log.debug("Update/insert for user: [{}]", user);
        userService.save(user);
        return user;
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    public User deleteUser(
            @PathVariable Integer id) {
        log.debug("Deleting user with id: {}", id);
        return userService.get(id);
    }



    @RequestMapping(value = "/status")
    public String status() {
        return "Application is running OK";
    }

    @RequestMapping(value = "/system")
    public SystemInfo systemInfo() {
        return new SystemInfo();
    }


}
