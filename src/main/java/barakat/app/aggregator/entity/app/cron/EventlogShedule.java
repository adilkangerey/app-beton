package barakat.app.aggregator.entity.app.cron;

import barakat.app.aggregator.entity.app.CronProperties;
import barakat.app.aggregator.entity.app.CronPropertiesException;
import barakat.app.aggregator.entity.app.TcTransportCopySchedule;
import barakat.app.aggregator.entity.app.repository.mirrorgen.EventlogTcRepository;
import barakat.app.aggregator.entity.tctransport.model.gen.Eventlog;
import barakat.app.aggregator.entity.tctransport.repository.EventlogCustomRepository;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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
    EventlogCustomRepository repository;
    @Autowired
    EventlogTcRepository tcRepository;
    @Autowired
    CronProperties cron;

    private String lastEventId = "eventlog.id.last";

    @Scheduled(fixedDelay = 1000*5)
    private void job() throws CronPropertiesException {
        String id = cron.get(lastEventId);
        Integer count =  isMuchMore()? 40000:1000;
        if (id == null){
            cron.save(lastEventId, "0");
        }else{
            List<Eventlog>  eventlogs = repository.queryById(Integer.valueOf(id), count);
            tcRepository.saveAll(eventlogs);
            if(eventlogs.size() != 0){
                cron.save(lastEventId, eventlogs.get(eventlogs.size()-1).getId().toString());
            }
        }
    }
    @Override
    public Logger getLogger() {
        return log;
    }
}