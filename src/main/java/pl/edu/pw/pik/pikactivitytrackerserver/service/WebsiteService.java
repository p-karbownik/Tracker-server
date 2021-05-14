package pl.edu.pw.pik.pikactivitytrackerserver.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pw.pik.pikactivitytrackerserver.DAO.Dao;
import pl.edu.pw.pik.pikactivitytrackerserver.DAO.WebsiteDAO;
import pl.edu.pw.pik.pikactivitytrackerserver.model.User;
import pl.edu.pw.pik.pikactivitytrackerserver.model.Website;

import java.util.Optional;

//it means that this class contains buisness logic
@Service
public class WebsiteService {

    private static Dao<Website> jpaWebsideDao;

    public static Website getWebsite(long id) {
        Optional<Website> website = jpaWebsideDao.get(id);

        return website.orElseGet(
                () -> new Website("no-non-existing url", -1));
    }

    public static void updateWebsite(Website website, String[] params) {
        jpaWebsideDao.update(website, params);
    }

    public static void saveWebsite(Website website) {
        jpaWebsideDao.save(website);
    }

    public static void deleteWebsite(Website website) {
        jpaWebsideDao.delete(website);
    }

}
