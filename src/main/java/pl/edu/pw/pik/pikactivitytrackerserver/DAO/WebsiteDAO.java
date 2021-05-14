package pl.edu.pw.pik.pikactivitytrackerserver.DAO;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.pw.pik.pikactivitytrackerserver.model.Website;


public interface WebsiteDAO extends JpaRepository<Website, Integer>{
}
