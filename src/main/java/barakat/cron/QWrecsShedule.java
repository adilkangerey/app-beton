package barakat.cron;

import barakat.app.repository.mirrorgen.QWrecsTcRepository;
import barakat.tctransport.model.gen.QWrecs;
import barakat.tctransport.repository.QWrecsCustomRepository;
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
public class QWrecsShedule implements TcTransportCopySchedule {
    @Autowired
    QWrecsCustomRepository repository;
    @Autowired
    QWrecsTcRepository tcRepository;
    @Autowired
    CronProperties cron;
    private String lastQWrecsId = "qwrecs.id.last";
    @Value("${tctransport.sync.entity.idcols}")
    Integer size;

    @Scheduled(fixedDelay = 1000*5)
    public void job() throws CronPropertiesException {
        String id = cron.get(lastQWrecsId);
        if (id == null){
            cron.save(lastQWrecsId, "0");
        }else{
            List<QWrecs> eventlogs = repository.queryById(Integer.valueOf(id), size);
            tcRepository.saveAll(eventlogs);
            if(eventlogs.size() != 0){
                cron.save(lastQWrecsId, eventlogs.get(eventlogs.size()-1).getId().toString());
            }
        }
    }
    @Override
    public Logger getLogger() {
        return log;
    }
}