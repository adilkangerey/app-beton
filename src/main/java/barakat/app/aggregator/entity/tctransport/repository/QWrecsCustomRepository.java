package barakat.app.aggregator.entity.tctransport.repository;

import barakat.app.aggregator.entity.tctransport.model.gen.QWrecs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* Generated by Spring Data Generator on 26/05/2022
*/
@Repository
public interface QWrecsCustomRepository extends JpaRepository<QWrecs, Integer>, JpaSpecificationExecutor<QWrecs> {
    @Query(value = "select e from barakat.app.aggregator.entity.tctransport.model.gen.QWrecs e where e.id >= :id and e.id < (:id+3000)")
    List<QWrecs> queryById(Integer id);
}
