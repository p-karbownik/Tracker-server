package pl.edu.pw.pik.pikactivitytrackerserver.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.pw.pik.pikactivitytrackerserver.Repository.WebsitesRepository;
import pl.edu.pw.pik.pikactivitytrackerserver.model.Website;

import java.util.List;

//it means that this class contains buisness logic
@Service
@Transactional
public class WebsiteService {

    @Autowired
    WebsitesRepository websitesRepository;

    public boolean addWebsite(Website website)
    {
        //buisness processing
        return true;
    }

    public List<Website> getWebsitesByUserId(Integer id)
    {
        return websitesRepository.getWebsitesByUserId(id);
    }

    public Website getSingleWebsite(int id)
    {
       return websitesRepository.getWebsiteByWebsite_id(id);
    }

    public void deleteWebsite(int id)
    {
        websitesRepository.deleteById(id);
    }

}
