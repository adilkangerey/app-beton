package barakat.app.aggregator.entity.tctransport.repository.gen;

import barakat.app.aggregator.entity.tctransport.model.gen.Eventlog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
* Generated by Spring Data Generator on 03/06/2022
*/
@Repository
public interface EventlogRepository extends JpaRepository<Eventlog, Integer>, JpaSpecificationExecutor<Eventlog> {

}
