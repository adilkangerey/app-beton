package barakat.tctransport.model.gen;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity(name = "barakat.app.aggregator.entity.tctransport.model.gen.QEvlog")
@Table(name = "Q_EVLOG")
public class QEvlog implements Serializable {

  @Id
  @Column(name = "\"ID\"", nullable = false)
  private Integer id;
  /**
   * ИД таблицы событий
   */
  @Column(name = "\"TID\"", nullable = true)
  private Integer tid;
}