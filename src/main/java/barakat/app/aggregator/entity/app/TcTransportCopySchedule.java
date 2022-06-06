package barakat.app.aggregator.entity.app;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.repository.CrudRepository;
import org.springframework.scheduling.annotation.Scheduled;


public interface TcTransportCopySchedule {

    Logger getLogger();
    CrudRepository getRepository();
    CrudRepository getTcRepository();

    @Scheduled(fixedDelay = 1000*60*1)
    default void count(){
        if(getRepository() == null){
            getLogger().info(getLogger().getName() + " | repository null");
        }else{
            String persent = persent();
            if(!persent.equals("100,00")){
                getLogger().info(getLogger().getName() + " | TCTransport-" + String.valueOf(getRepository().count()) + " | App-" + String.valueOf(getTcRepository().count()) + " | " + persent + "%");//

            }
        }
    }

    default String persent(){
        if(getRepository().count() == 0l){
            return "100,00";
        }else{
            if (getTcRepository().count() == 0l ){
                return "0,00";
            }else{
                return String.format("%,.2f",((new Double(Long.toString(getTcRepository().count()))/new Double(Long.toString(getRepository().count())))*100d));
            }
        }
    }
}
