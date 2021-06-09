package pl.edu.pw.pik.pikactivitytrackerserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.pw.pik.pikactivitytrackerserver.DTO.EventDTO;
import pl.edu.pw.pik.pikactivitytrackerserver.DTO.StatisticsDTO;
import pl.edu.pw.pik.pikactivitytrackerserver.dal.EventDAL;
import pl.edu.pw.pik.pikactivitytrackerserver.model.Event;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class EventService {
    @Autowired
    EventDAL eventDAL;

    public boolean saveEvent(EventDTO dto)
    {
        Event event = new Event();
        event.setEventName(dto.getEventName());
        event.setEventData(dto.getEventData());
        event.setWebsite_token(dto.getWebsiteToken());
        event.setId(UUID.randomUUID().toString());
        event.setEventOccurrenceLocalDateTime(dto.getAppearanceDate());
        try {
            eventDAL.saveEvent(event);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String getStatisticAboutEvent(String webSiteToken, String EventName, boolean dayFormat, Date dateFrom, Date dateTo)
    {
        return null;
    }

    public List<String> getEventNames(String websiteToken) throws Exception
    {
        return eventDAL.getUniqueEventNames(websiteToken);
    }
}
