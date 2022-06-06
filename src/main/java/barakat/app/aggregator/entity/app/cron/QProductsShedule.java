package barakat.app.aggregator.entity.app.cron;

import barakat.app.aggregator.entity.app.CronProperties;
import barakat.app.aggregator.entity.app.CronPropertiesException;
import barakat.app.aggregator.entity.app.TcTransportCopySchedule;
import barakat.app.aggregator.entity.app.repository.mirrorgen.QProductsTcRepository;
import barakat.app.aggregator.entity.tctransport.model.gen.QProducts;
import barakat.app.aggregator.entity.tctransport.repository.QProductsCustomRepository;
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
public class QProductsShedule implements TcTransportCopySchedule {
    @Autowired
    QProductsCustomRepository repository;
    @Autowired
    QProductsTcRepository tcRepository;
    @Autowired
    CronProperties cron;
    private String lastQProductsId = "qproducts.id.last";
    @Value("${tctransport.sync.entity.idcols}")
    Integer size;

    @Scheduled(fixedDelay = 1000*5)
    private void job() throws CronPropertiesException {
        String id = cron.get(lastQProductsId);
        if (id == null){
            cron.save(lastQProductsId, "0");
        }else{
            List<QProducts>  eventlogs = repository.queryById(Integer.valueOf(id), size);
            tcRepository.saveAll(eventlogs);
            if(eventlogs.size() != 0){
                cron.save(lastQProductsId, eventlogs.get(eventlogs.size()-1).getId().toString());
            }
        }
    }
    @Override
    public Logger getLogger() {
        return log;
    }
}
