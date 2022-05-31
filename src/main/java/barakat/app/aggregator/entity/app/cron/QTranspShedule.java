package barakat.app.aggregator.entity.app.cron;

import barakat.app.aggregator.entity.app.TcTransportCopySchedule;
import barakat.app.aggregator.entity.app.repository.mirrorgen.QTranspTcRepository;
import barakat.app.aggregator.entity.tctransport.repository.gen.QTranspRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

/**
* Generated by Spring Data Generator on 26/05/2022
*/
@Log4j2
@Configuration
public class QTranspShedule implements TcTransportCopySchedule {
    @Autowired
    QTranspRepository repository;
    @Autowired
    QTranspTcRepository tcRepository;

    @Scheduled(fixedDelay = 1000*60*30)
    private void job(){

        tcRepository.saveAll(repository.findAll());
    }
}
