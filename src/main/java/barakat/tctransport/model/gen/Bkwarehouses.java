package barakat.tctransport.model.gen;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

/**
 * Список складов
 */
@Data
@Entity(name = "barakat.app.aggregator.entity.tctransport.model.gen.Bkwarehouses")
@Table(name = "bkWarehouses")
public class Bkwarehouses implements Serializable {

  @Id
  @Column(name = "\"ID\"", nullable = false)
  private Integer id;
  @Column(name = "\"Name\"", nullable = false)
  private String name;
  @Column(name = "\"Enabled\"", nullable = false)
  private Short enabled;
  @Column(name = "\"CustomerLink\"", nullable = true)
  private Integer customerlink;
  @Column(name = "\"Notes\"", nullable = true)
  private String notes;
}