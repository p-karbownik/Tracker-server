package pl.edu.pw.pik.pikactivitytrackerserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.pw.pik.pikactivitytrackerserver.DTO.MainDTO;
import pl.edu.pw.pik.pikactivitytrackerserver.Repository.WebsitesRepository;
import pl.edu.pw.pik.pikactivitytrackerserver.dal.CollectionDAL;
import pl.edu.pw.pik.pikactivitytrackerserver.exeptions.CollectionDoesNotExistException;
import pl.edu.pw.pik.pikactivitytrackerserver.model.Event;
import pl.edu.pw.pik.pikactivitytrackerserver.model.Website;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class MainService {

    @Autowired
    CollectionDAL collectionDAL;

    @Autowired
    WebsitesRepository websitesRepository;

    public List<MainDTO> getMainData(int userId) {
        List<Website> websites = websitesRepository.getWebsitesByUserId(userId);
        List<MainDTO> result = new ArrayList<>();

        for (Website website : websites) {
            int websiteId = website.getWebsite_id();
            String websiteName = website.getName();
            String token = website.getToken();

            int numberOfEvents;
            Timestamp lastEventTimestamp;
            String mostPopularEventName;

            try {
                List<Event> events = collectionDAL.getEventsFromCollection(token);
                //TODO get info from events
                System.out.println("ala");
            } catch (CollectionDoesNotExistException c) {
                numberOfEvents = 0;
                lastEventTimestamp = null;
                mostPopularEventName = null;
            }


//            MainDTO mainDTO = new MainDTO(websiteId, websiteName,
//                    numberOfEvents,
//                    lastEventTimestamp,
//                    mostPopularEventName);

        }
        return null;
    }

}
