package barakat.app.repository;

import barakat.app.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
* Generated by Spring Data Generator on 03/06/2022
*/
@Repository
public interface OrdersRepository extends JpaRepository<Order, Integer>, JpaSpecificationExecutor<Order> {

}