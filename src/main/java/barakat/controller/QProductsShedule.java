package barakat.controller;

import barakat.app.repository.QProductsCustomRepository;
import barakat.app.repository.mirrorgen.QProductsTcRepository;
import barakat.tctransport.model.gen.QProducts;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

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
    CronProperties cron;
    private String lastQProductsId = "qproducts.id.last";
    @Value("${tctransport.sync.entity.idcols}")
    Integer size;

    //@Scheduled(fixedDelay = 1000*5)
    public void job() throws CronPropertiesException {
        String id = cron.get(lastQProductsId);
        if (id == null){
            cron.save(lastQProductsId, "0");
        }else{
            List<QProducts>  eventlogs = repository.queryById(Integer.valueOf(id), size);
            repository.saveAll(eventlogs);
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
