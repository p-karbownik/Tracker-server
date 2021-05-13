package pl.edu.pw.pik.pikactivitytrackerserver.DAO;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.pw.pik.pikactivitytrackerserver.model.User;

public interface UserDAO extends JpaRepository<User, Integer>{
}
