package pl.edu.pw.pik.pikactivitytrackerserver.DAO;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.pw.pik.pikactivitytrackerserver.model.Website;

import java.util.Optional;


public class WebsiteDAO implements Dao<Website>{
    @Override
    public Optional<Website> get(Long id) {
        //TODO
        return Optional.empty();
    }

    @Override
    public void save(Website website) {
        //TODO
    }

    @Override
    public void update(Website website, String[] params) {
        //TODO
    }

    @Override
    public void delete(Website website) {
        //TODO
    }
}
