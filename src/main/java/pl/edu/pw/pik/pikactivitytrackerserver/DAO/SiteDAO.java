package pl.edu.pw.pik.pikactivitytrackerserver.DAO;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.pw.pik.pikactivitytrackerserver.model.Site;


public interface SiteDAO extends JpaRepository<Site, Integer>{
}
