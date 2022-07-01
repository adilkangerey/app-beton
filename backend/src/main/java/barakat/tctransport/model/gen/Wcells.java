package barakat.tctransport.model.gen;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

/**
 * Сведения о датчиках, принимающих участие во взвешивании
 */
@Data
@Entity(name = "barakat.app.aggregator.entity.tctransport.model.gen.Wcells")
@Table(name = "wCells")
@IdClass(Wcells.PrimaryKeys.class)
public class Wcells implements Serializable {
  @Data
  public static class PrimaryKeys implements Serializable {
    private Integer wplatformlink;
    private Short cellno;
  }

  @Id
  @Column(name = "\"wPlatformLink\"", nullable = false)
  private Integer wplatformlink;
  /**
   * Номер датчика (1..n)
   */
  @Id
  @Column(name = "\"CellNo\"", nullable = false)
  private Short cellno;
  @Column(name = "\"Weight\"", nullable = false)
  private Integer weight;
  @Column(name = "\"Status\"", nullable = false)
  private Short status;
}