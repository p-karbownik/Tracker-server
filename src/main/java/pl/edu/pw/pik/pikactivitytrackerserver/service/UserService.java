package pl.edu.pw.pik.pikactivitytrackerserver.service;
import org.springframework.stereotype.Service;
import pl.edu.pw.pik.pikactivitytrackerserver.DAO.Dao;
import pl.edu.pw.pik.pikactivitytrackerserver.model.User;

import java.util.Optional;

//it means that this class contains buisness logic
@Service
public class UserService {

    private static Dao<User> userDao;

    public static User getUser(long id) {
        Optional<User> user = userDao.get(id);

        return user.orElseGet(
                () -> new User("no-non-existing login", "non-existing password"));
    }

    public static void updateUser(User user, String[] params) {
        userDao.update(user, params);
    }

    public static void saveUser(User user) {
        userDao.save(user);
    }

    public static void deleteUser(User user) {
        userDao.delete(user);
    }
}
