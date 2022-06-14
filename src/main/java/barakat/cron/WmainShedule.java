package barakat.cron;

import barakat.app.repository.mirrorgen.WmainTcRepository;
import barakat.tctransport.model.gen.Wmain;
import barakat.tctransport.repository.WmainCustomRepository;
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
public class WmainShedule implements TcTransportCopySchedule, TcTransportUpdateSchedule {
    @Autowired
    WmainCustomRepository repository;
    @Autowired
    WmainTcRepository tcRepository;
    @Autowired
    CronProperties cron;
    private String lastQWrecsId = "wmain.id.last";
    @Value("${tctransport.sync.entity.large}")
    Integer size;
    @Scheduled(fixedDelay = 1000*10)
    public void job() throws CronPropertiesException {

        String id = cron.get(lastQWrecsId);
        if (id == null){
            cron.save(lastQWrecsId, "0");
        }else{
            List<Wmain> eventlogs = repository.queryById(Integer.valueOf(id), size);
            tcRepository.saveAll(eventlogs);
            if(eventlogs.size() != 0){
                cron.save(lastQWrecsId, eventlogs.get(eventlogs.size()-1).getId().toString());
            }
        }
    }

    @Scheduled(fixedDelay = 1000*10)
    public void update() throws CronPropertiesException {
        Integer usize = 500;
        String id = cron.get(lastQWrecsId);

        if (id != null){
            Integer id_ = Integer.parseInt(id);
            id_ -= usize; if(id_ < 0) id_ = 0;
            List<Wmain> wunits = repository.queryById(id_, usize);
            tcRepository.saveAll(wunits);
        }
    }

    @Override
    public Logger getLogger() {
        return log;
    }
}