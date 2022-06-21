package barakat.controller;

import barakat.app.repository.mirrorgen.EventlogTcRepository;
import barakat.tctransport.model.gen.Eventlog;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;

/**
* Generated by Spring Data Generator on 26/05/2022
*/

@Log4j2
@Getter
@Configuration
public class EventlogShedule implements TcTransportCopySchedule {
    @Autowired
    EventlogTcRepository repository;
    @Autowired
    CronProperties cron;
    @Value("${tctransport.sync.entity.large}")
    Integer size;

    private String lastEventId = "eventlog.id.last";


    //@Scheduled(fixedDelay = 1000*5)
    public void job() throws CronPropertiesException {
        return;
//        String id = cron.get(lastEventId);
//        if (id == null){
//            cron.save(lastEventId, "0");
//        }else{
//            List<Eventlog>  eventlogs = repository.queryById(Integer.valueOf(id), size);
//            tcRepository.saveAll(eventlogs);
//            if(eventlogs.size() != 0){
//                cron.save(lastEventId, eventlogs.get(eventlogs.size()-1).getId().toString());
//            }
//        }
    }
    @Override
    public Logger getLogger() {
        return log;
    }
}
