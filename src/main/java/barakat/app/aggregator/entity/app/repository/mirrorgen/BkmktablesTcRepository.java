package barakat.app.aggregator.entity.app.repository.mirrorgen;

import barakat.app.aggregator.entity.tctransport.model.gen.Bkmktables;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
* Generated by Spring Data Generator on 03/06/2022
*/
@Repository
public interface BkmktablesTcRepository extends JpaRepository<Bkmktables, Integer>, JpaSpecificationExecutor<Bkmktables> {

}
