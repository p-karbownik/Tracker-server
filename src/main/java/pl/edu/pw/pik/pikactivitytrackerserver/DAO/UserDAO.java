package pl.edu.pw.pik.pikactivitytrackerserver.DAO;
import pl.edu.pw.pik.pikactivitytrackerserver.model.User;

import javax.persistence.EntityManager;
import java.util.Optional;

public class UserDAO implements Dao<User> {

    private EntityManager entityManager;

    @Override
    public Optional<User> get(Long id) {
        //TODO
        return Optional.empty();
    }

    @Override
    public void save(User user) {
        //TODO
    }

    @Override
    public void update(User user, String[] params) {
        //TODO
    }

    @Override
    public void delete(User user) {
        //TODO
    }
}
