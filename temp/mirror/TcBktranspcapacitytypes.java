package barakat.app.aggregator.entity.app.model.mirror;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table
public class TcBktranspcapacitytypes implements Serializable {

  @Id
  @Column(name = "\"ID\"", nullable = false)
  private Integer id;
  /**
   * Названия элементов во всех справочниках
   */
  @Column(name = "\"Name\"", nullable = false)
  private String name;
  /**
   * Грузоподъемность миним, кг
   */
  @Column(name = "\"CapacityMin\"", nullable = false)
  private Integer capacitymin;
  @Column(name = "\"CapacityMax\"", nullable = true)
  private Integer capacitymax;
  /**
   * Допустимый перегруз, кг
   */
  @Column(name = "\"Overweight\"", nullable = true)
  private Integer overweight;
}