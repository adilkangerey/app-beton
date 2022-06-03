package barakat.app.aggregator.entity.tctransport.model.gen;

import java.io.Serializable;
import java.sql.*;
import javax.persistence.*;
import lombok.Data;

/**
 * Журнал изменения веса на весах
 */
@Data
@Entity(name = "barakat.app.aggregator.entity.tctransport.model.gen.Weightlog")
@Table(name = "WeightLog")
public class Weightlog implements Serializable {

  @Id
  @Column(name = "\"ID\"", nullable = false)
  private Integer id;
  @Column(name = "\"At\"", nullable = false)
  private Timestamp at;
  @Column(name = "\"ScaleNo\"", nullable = false)
  private Integer scaleno;
  /**
   * весовая
   */
  @Column(name = "\"WPoint\"", nullable = false)
  private Integer wpoint;
  @Column(name = "\"Weight\"", nullable = false)
  private Integer weight;
  @Column(name = "\"Stable\"", nullable = false)
  private Short stable;
  @Column(name = "\"Valid\"", nullable = false)
  private Short valid;
}