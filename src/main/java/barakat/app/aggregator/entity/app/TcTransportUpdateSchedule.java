package barakat.app.aggregator.entity.app;

import org.apache.logging.log4j.Logger;
import org.springframework.data.repository.CrudRepository;
import org.springframework.scheduling.annotation.Scheduled;



//wunits.id.last=80293
//wmain.id.last=80333
//wcargo.id.last=80685
public interface TcTransportUpdateSchedule {

    Logger getLogger();
    CrudRepository getRepository();
    CrudRepository getTcRepository();
    void update() throws CronPropertiesException;
}
