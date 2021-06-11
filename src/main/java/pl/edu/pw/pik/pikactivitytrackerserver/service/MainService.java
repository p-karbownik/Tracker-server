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
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

            int numberOfEvents = 0;
            Timestamp lastEventTimestamp = null;
            String mostPopularEventName = null;

            try {
                List<Event> events = collectionDAL.getEventsFromCollection(token);

                if(events.size() > 0){
                    numberOfEvents = events.size();
                    LocalDateTime tmp = events.get(numberOfEvents-1).getEventOccurrenceLocalDateTime();
//                    lastEventTimestamp =
                    mostPopularEventName = getMostPopularEventName(events);
                }
            } catch (CollectionDoesNotExistException c) {
                numberOfEvents = 0;
                lastEventTimestamp = null;
                mostPopularEventName = null;
            }


            MainDTO mainDTO = new MainDTO(websiteId, websiteName, token,
                    numberOfEvents, lastEventTimestamp, mostPopularEventName);

            result.add(mainDTO);
        }
        return result;
    }

    private String getMostPopularEventName(List<Event> events) {
        Map<String,Integer> namesCount = new HashMap();

        for(Event event : events){
            if( namesCount.containsKey(event.getEventName()) ){
                namesCount.put(event.getEventName(), namesCount.get(event.getEventName()) + 1);
            } else {
                namesCount.put(event.getEventName(), 1 );
            }
        }

        int maxValue = 0;
        String mostPopularName = "";
        for (Map.Entry<String , Integer> entry : namesCount.entrySet()) {
            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
                mostPopularName = entry.getKey();
            }
        }
        return mostPopularName;
    }

}
