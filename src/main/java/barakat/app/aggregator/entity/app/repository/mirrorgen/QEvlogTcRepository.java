package barakat.app.aggregator.entity.app.repository.mirrorgen;

import barakat.app.aggregator.entity.tctransport.model.gen.QEvlog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
* Generated by Spring Data Generator on 26/05/2022
*/
@Repository
public interface QEvlogTcRepository extends JpaRepository<QEvlog, Integer>, JpaSpecificationExecutor<QEvlog> {

}
