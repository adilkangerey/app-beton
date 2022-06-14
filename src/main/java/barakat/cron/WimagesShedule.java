package barakat.cron;

import barakat.app.repository.mirrorgen.WimagesTcRepository;
import barakat.tctransport.repository.gen.WimagesRepository;
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
public class WimagesShedule implements TcTransportCopySchedule {
    @Autowired
    WimagesRepository repository;
    @Autowired
    WimagesTcRepository tcRepository;

    @Override
    public Logger getLogger() {
        return log;
    }
}