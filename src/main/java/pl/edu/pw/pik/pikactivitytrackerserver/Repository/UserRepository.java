package pl.edu.pw.pik.pikactivitytrackerserver.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.edu.pw.pik.pikactivitytrackerserver.model.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

//    User findByUsername(String username);

    @Query(value = "select * from users where username = ?", nativeQuery = true)
    List<User> findByUsername(String username);

}
