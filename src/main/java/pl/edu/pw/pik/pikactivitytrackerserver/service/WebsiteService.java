package pl.edu.pw.pik.pikactivitytrackerserver.service;


import com.mongodb.client.MongoCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.metrics.MetricsProperties;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import pl.edu.pw.pik.pikactivitytrackerserver.DTO.WebsiteDTO;
import pl.edu.pw.pik.pikactivitytrackerserver.Repository.WebsitesRepository;
import pl.edu.pw.pik.pikactivitytrackerserver.model.Website;

import java.util.List;
import java.util.UUID;

//it means that this class contains buisness logic
@Service
@Transactional
public class WebsiteService {
    @Autowired
    WebsitesRepository websitesRepository;

    @Autowired
    CollectionDAL collectionDAL;

    private String generateToken()
    {
        return UUID.randomUUID().toString();
    }

    public String addWebsite(WebsiteDTO dto)
    {
        Website website = new Website();
        website.setUser_id(dto.getUser_id());
        website.setUrl(dto.getUrl());
        website.setName(dto.getWebsiteName());

        String token;
        Website tempWebsite = null;
        do {
            token = generateToken();
            tempWebsite = websitesRepository.getWebsiteByToken(token);

        }while (tempWebsite != null);

        if(websitesRepository.getWebsiteByUrl(dto.getUrl()) != null)
            return null;
        website.setToken(token);
        collectionDAL.createCollection(token);
        websitesRepository.save(website);

        return token;
    }

    public List<Website> getWebsitesByUserId(Integer id)
    {
        return websitesRepository.getWebsitesByUserId(id);
    }

    public Website getSingleWebsite(int id)
    {
       return websitesRepository.getWebsiteByWebsite_id(id);
    }

    public void deleteWebsite(int user_id, int website_id)
    {
        Website ws = websitesRepository.getWebsiteByWebsite_idAndUser_id(website_id, user_id);

        if(ws != null)
            if (websitesRepository.existsById(website_id)) {
                collectionDAL.dropCollection(ws.getToken());
                websitesRepository.deleteById(website_id);
            }
    }

    public void deleteWebsitesByUserId(int user_id)
    {
        List<Website> websitesToDelete = websitesRepository.getWebsitesByUserId(user_id);
        websitesRepository.deleteAll(websitesToDelete);
    }
}
