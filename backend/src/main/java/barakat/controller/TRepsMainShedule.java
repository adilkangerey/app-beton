package barakat.controller;

import barakat.app.repository.mirrorgen.TRepsMainTcRepository;
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
public class TRepsMainShedule implements TcTransportCopySchedule {
    @Autowired
    TRepsMainTcRepository repository;

    @Override
    public Logger getLogger() {
        return log;
    }
}
