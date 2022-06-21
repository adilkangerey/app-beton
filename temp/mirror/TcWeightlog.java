package barakat.app.entity.mirror;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Журнал изменения веса на весах
 */
@Data
@Entity
@Table
public class TcWeightlog implements Serializable {

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