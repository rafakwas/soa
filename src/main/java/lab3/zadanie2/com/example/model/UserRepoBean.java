package lab3.zadanie2.com.example.model;

//import javax.enterprise.context.ApplicationScoped;
import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;


@Stateless
public class UserRepoBean implements UserRepo {
    private List<User> list = new ArrayList<User>();

    @Override
    public void add(User user) {
        list.add(user);
    }

    @Override
    public void remove(User user) {
        list.remove(user);
    }

    @Override
    public List<User> getList() {
        return list;
    }

}
