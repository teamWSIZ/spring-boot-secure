package app.model;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;


public interface UserRepo extends CrudRepository<User,Integer> {
    List<User> getByActiveTrue();
    List<User> getByBirthdateAfter(Date d);
    User getByUsername(String username);
}

//    @Query("select s from User s, UserGroup ug " +
//            "where s.userid = ug.userid and ug.groupid = ?1")
//    List<User> getByGroupid(Integer grupid);