package barakat.app.aggregator.entity.app;

import org.apache.logging.log4j.Logger;
import org.springframework.data.repository.CrudRepository;
import org.springframework.scheduling.annotation.Scheduled;


public interface TcTransportCopySchedule {

    Logger getLogger();
    CrudRepository getRepository();
    CrudRepository getTcRepository();

    @Scheduled(fixedDelay = 1000*60*1)
    default void count(){
        if(getRepository() == null){
            getLogger().info("repository null");
        }else{
            String persent = persent();
            if(!persent.equals("100,00")){
                getLogger().info("tctransport " + String.valueOf(getRepository().count()) + " - app " + String.valueOf(getTcRepository().count()) + " total persent " + persent + "%");//
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

    default Boolean isMuchMore(){
        long count  =getRepository().count() ;
        if(count == 0l){
            return false;
        }else{
            long difcount  = count - getTcRepository().count();
            return difcount > 3000;
        }
    }
}
