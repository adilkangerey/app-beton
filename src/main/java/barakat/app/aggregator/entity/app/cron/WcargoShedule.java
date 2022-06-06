package barakat.app.aggregator.entity.app.cron;

import barakat.app.aggregator.entity.app.CronProperties;
import barakat.app.aggregator.entity.app.CronPropertiesException;
import barakat.app.aggregator.entity.app.TcTransportCopySchedule;
import barakat.app.aggregator.entity.app.repository.mirrorgen.WcargoTcRepository;
import barakat.app.aggregator.entity.tctransport.model.gen.Wcargo;
import barakat.app.aggregator.entity.tctransport.repository.WcargoCustomRepository;
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
public class WcargoShedule implements TcTransportCopySchedule {
    @Autowired
    WcargoCustomRepository repository;
    @Autowired
    WcargoTcRepository tcRepository;
    @Autowired
    CronProperties cron;
    private String lastWcargoId = "wcargo.id.last";
    @Value("${tctransport.sync.entity.large}")
    Integer size;

    @Scheduled(fixedDelay = 1000*10)
    private void job() throws CronPropertiesException {
        String id = cron.get(lastWcargoId);
        if (id == null){
            cron.save(lastWcargoId, "0");
        }else{
            List<Wcargo> eventlogs = repository.queryById(Integer.valueOf(id), size);
            tcRepository.saveAll(eventlogs);
            if(eventlogs.size() != 0){
                cron.save(lastWcargoId, eventlogs.get(eventlogs.size()-1).getId().toString());
            }
        }
    }
    @Override
    public Logger getLogger() {
        return log;
    }
}