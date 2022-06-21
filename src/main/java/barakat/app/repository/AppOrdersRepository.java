package barakat.app.repository;

import barakat.app.entity.AppOrders;
import barakat.app.view.AppOrdersDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* Generated by Spring Data Generator on 03/06/2022
*/
@Repository
public interface AppOrdersRepository extends JpaRepository<AppOrders, Integer>, JpaSpecificationExecutor<AppOrders> {
    @Query("select new barakat.app.view.AppOrdersDetail(c.bkProductId, c.id, c.bkCustomerId, c.coneSediment, c.construction, c.createAt, c.createdUser, c.cubicMeter,c.endTime,c.intervalComment,c.intervalMinutes,c.startTime, c.bkWarehouseId, cli.name, p.name, w.name) from AppOrders c " +
            " left join barakat.app.aggregator.entity.tctransport.model.gen.Bkproducts p on p.id = c.bkProductId" +
            " left join barakat.app.aggregator.entity.tctransport.model.gen.Bkcustomers cli on cli.id = c.bkCustomerId" +
            " left join barakat.app.aggregator.entity.tctransport.model.gen.Bkwarehouses w on w.id = c.bkWarehouseId order by c.id DESC" )
    Page<AppOrdersDetail> detailView(Pageable pageable);

}
