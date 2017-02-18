package app.model;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

/**
 * Dokumentacja w:
 * https://docs.spring.io/spring-data/jpa/docs/current/reference/html/
 *
 *
 * Table 4. Supported keywords inside method names
 */
public interface UserRepo extends CrudRepository<User,Integer> {
    List<User> getByActiveTrue();
    List<User> getByBirthdateAfter(Date d);
    List<User> getByUsername(String username);
    List<User> getByBirthdate(Date d);
}

//    @Query("select s from User s, UserGroup ug " +
//            "where s.userid = ug.userid and ug.groupid = ?1")
//    List<User> getByGroupid(Integer grupid);