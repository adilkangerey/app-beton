package barakat.app.repository.mirrorgen;

import barakat.tctransport.model.gen.Wunits;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
* Generated by Spring Data Generator on 03/06/2022
*/
@Repository
public interface WunitsTcRepository extends JpaRepository<Wunits, Integer>, JpaSpecificationExecutor<Wunits> {

}
