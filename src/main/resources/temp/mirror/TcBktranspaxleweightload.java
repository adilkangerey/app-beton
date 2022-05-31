package barakat.app.aggregator.entity.app.model.mirror;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Типы транспорта по осевым нагрузкам
 */
@Data
@Entity
@Table
public class TcBktranspaxleweightload implements Serializable {

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