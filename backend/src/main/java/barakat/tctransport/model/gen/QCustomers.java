package barakat.tctransport.model.gen;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity(name = "barakat.app.aggregator.entity.tctransport.model.gen.QCustomers")
@Table(name = "Q_CUSTOMERS")
public class QCustomers implements Serializable {

  @Id
  @Column(name = "\"ID\"", nullable = false)
  private Integer id;
  @Column(name = "\"TID\"", nullable = true)
  private Integer tid;
}