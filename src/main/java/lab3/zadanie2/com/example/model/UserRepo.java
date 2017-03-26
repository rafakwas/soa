package lab3.zadanie2.com.example.model;

import javax.ejb.Local;
import javax.ejb.Remote;
import java.util.List;

public interface UserRepo {
    void add(User user);
    void remove(User user);
    List<User> getList();
}
