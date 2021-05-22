package pl.edu.pw.pik.pikactivitytrackerserver.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.pw.pik.pikactivitytrackerserver.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {


}
