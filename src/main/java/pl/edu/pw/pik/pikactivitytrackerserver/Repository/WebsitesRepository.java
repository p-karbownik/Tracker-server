package pl.edu.pw.pik.pikactivitytrackerserver.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.edu.pw.pik.pikactivitytrackerserver.model.Website;

import java.util.List;

@Repository
public interface WebsitesRepository extends JpaRepository<Website, Integer>{

    @Query(value = "select * from websites where user_id = ?", nativeQuery = true)
    List<Website> getWebsitesByUserId(Integer userId);

    @Query(value = "select * from websites where website_id = ?", nativeQuery = true)
    Website getWebsiteByWebsite_id(Integer id);

    @Query(value = "select * from websites where token = ?", nativeQuery = true)
    Website getWebsiteByToken(String token);

    @Query(value = "select * from websites where website_id = ? and user_id = ?", nativeQuery = true)
    Website getWebsiteByWebsite_idAndUser_id(int website_id, int user_id);

}
