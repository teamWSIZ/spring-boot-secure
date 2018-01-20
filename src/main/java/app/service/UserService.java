package app.service;


import app.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Serwis zarządzający dostępem do bazy userów systemu.
 */
public class UserService {
    Map<Integer, User> userStore = new HashMap<>();
    AtomicInteger idSqeuence = new AtomicInteger(0);

    public UserService() {
        createExampleUsers();
    }


    public User save(User u) {
        if (u.getUserid()==null) {
            u.setUserid(getNewId());   //procedura nadawania id-ków
        }
        userStore.put(u.getUserid(), u);
        return u;
    }

    public User get(Integer id) {
        return userStore.get(id);
    }

    public int count() {
        return userStore.size();
    }

    public List<User> getAll() {
        List<User> result = new ArrayList<>();
        for(User u : userStore.values()) {
            result.add(u);
        }
        return result;
    }

    private int getNewId() {
        return idSqeuence.incrementAndGet();
    }

    private void createExampleUsers() {
        save(new User(getNewId(), "Karramba", "123"));
        save(new User(getNewId(), "FiNdMe", "321"));
        save(new User(getNewId(), "Gates", "111"));
    }


}
