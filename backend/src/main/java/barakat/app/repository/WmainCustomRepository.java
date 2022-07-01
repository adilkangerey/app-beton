package barakat.app.repository;

import barakat.tctransport.model.gen.Wmain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* Generated by Spring Data Generator on 26/05/2022
*/
@Repository
public interface WmainCustomRepository extends JpaRepository<Wmain, Integer>, JpaSpecificationExecutor<Wmain> {
    @Query(value = "select e from barakat.app.aggregator.entity.tctransport.model.gen.Wmain e where e.id >= :id and e.id < (:id+:count)")
    List<Wmain> queryById(Integer id, Integer count);
}