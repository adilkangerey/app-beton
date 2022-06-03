package barakat.app.aggregator.entity.tctransport.model.gen;

import java.io.Serializable;
import java.sql.*;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity(name = "barakat.app.aggregator.entity.tctransport.model.gen.Bktranspcapacitytypes")
@Table(name = "bkTranspCapacityTypes")
public class Bktranspcapacitytypes implements Serializable {

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