package barakat.tctransport.model.gen;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

/**
 * Типы транспорта по осевым нагрузкам
 */
@Data
@Entity(name = "barakat.app.aggregator.entity.tctransport.model.gen.Bktranspaxleweightload")
@Table(name = "bkTranspAxleWeightLoad")
public class Bktranspaxleweightload implements Serializable {

  @Id
  @Column(name = "\"ID\"", nullable = false)
  private Integer id;
  /**
   * Названия элементов во всех справочниках
   */
  @Column(name = "\"Name\"", nullable = false)
  private String name;
  @Column(name = "\"WeightMin\"", nullable = true)
  private Integer weightmin;
  @Column(name = "\"WeightMax\"", nullable = true)
  private Integer weightmax;
}