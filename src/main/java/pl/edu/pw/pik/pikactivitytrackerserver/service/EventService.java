package pl.edu.pw.pik.pikactivitytrackerserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.pw.pik.pikactivitytrackerserver.DTO.EventDTO;
import pl.edu.pw.pik.pikactivitytrackerserver.DTO.StatisticsDTO;
import pl.edu.pw.pik.pikactivitytrackerserver.dal.EventDAL;
import pl.edu.pw.pik.pikactivitytrackerserver.model.Event;

import javax.persistence.criteria.CriteriaBuilder;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

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
        event.setEventOccurrenceLocalDateTime(dto.getAppearanceDate().toLocalDateTime());
        try {
            eventDAL.saveEvent(event);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<String> getEventsNames(String webToken) {
        List<String> list;
        try
        {
            list = eventDAL.getUniqueEventNames(webToken);
        }
        catch (Exception e)
        {
            return null;
        }

        return list;
    }


    public StatisticsDTO getStatisticsPerDay(String webToken, String eventName,
                                          Timestamp dateFrom, Timestamp dateTo)
    {
        List<Event> result = eventDAL.getEventsByNamesAndDates(webToken, eventName,dateFrom, dateTo);
        Collections.sort(result);

        Map<LocalDate, Integer> occurrencesPerDay = new HashMap<LocalDate, Integer>();
        for (Event e : result)
        {
            LocalDateTime temp = e.getEventOccurrenceLocalDateTime();
            LocalDate temp1 = temp.toLocalDate();

            int count = occurrencesPerDay.containsKey(temp1) ? occurrencesPerDay.get(temp1) : 0;
            occurrencesPerDay.put(temp1, count + 1);
        }

        TreeMap<LocalDate, Integer> sorted = new TreeMap<>();

        sorted.putAll(occurrencesPerDay);

        Set<LocalDate> dates = sorted.keySet();
        ArrayList<String> labels = new ArrayList<>();
        ArrayList<Integer> amountOfEvents = new ArrayList<>();

        for (Map.Entry<LocalDate, Integer> entry : sorted.entrySet())
        {
            labels.add(entry.getKey().toString());
            amountOfEvents.add(entry.getValue());
        }

        StatisticsDTO stat = new StatisticsDTO(eventName, labels, amountOfEvents);
        return stat;
    }
}
