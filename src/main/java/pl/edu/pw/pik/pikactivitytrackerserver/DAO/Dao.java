package pl.edu.pw.pik.pikactivitytrackerserver.DAO;

import java.util.Optional;

public interface Dao<T> {

    Optional<T> get(Long id);

    void save(T t);

    void update(T t, String[] params);

    void delete(T t);
}