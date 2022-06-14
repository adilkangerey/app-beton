package barakat.cron;

import barakat.app.repository.mirrorgen.BkusergroupsTcRepository;
import barakat.tctransport.repository.gen.BkusergroupsRepository;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

/**
* Generated by Spring Data Generator on 26/05/2022
*/
@Log4j2
@Getter
@Configuration
public class BkusergroupsShedule implements TcTransportCopySchedule {
    @Autowired
    BkusergroupsRepository repository;
    @Autowired
    BkusergroupsTcRepository tcRepository;

    @Override
    public Logger getLogger() {
        return log;
    }
}