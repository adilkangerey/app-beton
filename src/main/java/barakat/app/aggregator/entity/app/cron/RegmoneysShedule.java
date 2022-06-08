package barakat.app.aggregator.entity.app.cron;

import barakat.app.aggregator.entity.app.TcTransportCopySchedule;
import barakat.app.aggregator.entity.app.repository.mirrorgen.RegmoneysTcRepository;
import barakat.app.aggregator.entity.tctransport.repository.gen.RegmoneysRepository;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

/**
* Generated by Spring Data Generator on 26/05/2022
*/
@Log4j2
@Getter
@Configuration
public class RegmoneysShedule implements TcTransportCopySchedule {
    @Autowired
    RegmoneysRepository repository;
    @Autowired
    RegmoneysTcRepository tcRepository;

    @Override
    public Logger getLogger() {
        return log;
    }
}
