package barakat.app.aggregator.entity.app.repository.mirrorgen;

import barakat.app.aggregator.entity.tctransport.model.gen.QTransp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
* Generated by Spring Data Generator on 26/05/2022
*/
@Repository
public interface QTranspTcRepository extends JpaRepository<QTransp, Integer>, JpaSpecificationExecutor<QTransp> {

}
