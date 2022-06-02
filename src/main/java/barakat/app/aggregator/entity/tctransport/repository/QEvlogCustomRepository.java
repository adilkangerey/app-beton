package barakat.app.aggregator.entity.tctransport.repository;

import barakat.app.aggregator.entity.tctransport.model.gen.QEvlog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* Generated by Spring Data Generator on 26/05/2022
*/
@Repository
public interface QEvlogCustomRepository extends JpaRepository<QEvlog, Integer>, JpaSpecificationExecutor<QEvlog> {

    @Query(value = "select e from barakat.app.aggregator.entity.tctransport.model.gen.QEvlog e where e.id >= :id and e.id < (:id+:count)")
    List<QEvlog> queryById(Integer id, Integer count);
}
