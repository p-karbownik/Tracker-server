package pl.edu.pw.pik.pikactivitytrackerserver.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pw.pik.pikactivitytrackerserver.DAO.SiteDAO;

//it means that this class contains buisness logic
@Service
public class SiteService {

    @Autowired
    private SiteDAO siteDAO;

}
