package barakat.app.aggregator.entity.app.cron;

import barakat.app.aggregator.entity.app.CronProperties;
import barakat.app.aggregator.entity.app.CronPropertiesException;
import barakat.app.aggregator.entity.app.TcTransportCopySchedule;
import barakat.app.aggregator.entity.app.repository.mirrorgen.QEvlogTcRepository;
import barakat.app.aggregator.entity.tctransport.model.gen.QEvlog;
import barakat.app.aggregator.entity.tctransport.repository.QEvlogCustomRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;

/**
* Generated by Spring Data Generator on 26/05/2022
*/
@Log4j2
@Configuration
public class QEvlogShedule implements TcTransportCopySchedule {
    @Autowired
    QEvlogCustomRepository repository;
    @Autowired
    QEvlogTcRepository tcRepository;

    private String lastQevlogId = "qevlog.id.last";

    @Scheduled(fixedDelay = 1000*60*2)
    private void job() throws CronPropertiesException {

        String id = CronProperties.get(lastQevlogId);
        if (id == null){
            CronProperties.save(lastQevlogId, "0");
        }else{
            List<QEvlog>  eventlogs = repository.queryById(Integer.valueOf(id));
            tcRepository.saveAll(eventlogs);
            if(eventlogs.size() != 0){
                CronProperties.save(lastQevlogId, eventlogs.get(eventlogs.size()-1).getId().toString());
            }
        }
    }
}

