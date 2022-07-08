package barakat.app.view;

import barakat.app.entity.AppOrders;
import barakat.tctransport.model.gen.Wmain;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class AppOrdersDetail extends AppOrders {
    private String customerName;
    private String productName;
    private String warehouseName;

    public AppOrdersDetail(Integer bkProductId, Integer id, Integer bkCustomerId, Float coneSediment,
                           String construction, LocalDateTime createAt, String createdUser,
                           Float cubicMeter, LocalDateTime endTime, String intervalComment, Integer intervalMinutes,
                           LocalDateTime startTime,Integer bkWarehouseId, String customerName, String productName, String warehouseName, String status) {
        this.setBkProductId(bkProductId);
        this.setId(id);
        this.setBkCustomerId(bkCustomerId);
        this.setBkWarehouseId(bkWarehouseId);
//        this.setBkWarehouseOutId(appOrders.getBkWarehouseOutId());
        this.setCreateAt(createAt);
        this.setCreatedUser(createdUser);
        this.setCubicMeter(cubicMeter);
        this.setConstruction(construction);
        this.setConeSediment(coneSediment);
//        this.setWMains(appOrders.getWMains());
        this.setStartTime(startTime);
        this.setEndTime(endTime);
        this.setIntervalComment(intervalComment);
        this.setIntervalMinutes(intervalMinutes);
        this.setStatus(status);
        this.customerName = customerName;
        this.productName = productName;
        this.warehouseName = warehouseName;
    }
}
