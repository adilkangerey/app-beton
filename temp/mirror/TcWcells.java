package barakat.app.entity.mirror;

import lombok.Data;

import java.io.Serializable;

/**
 * Сведения о датчиках, принимающих участие во взвешивании
 */
@Data
@Entity
@Table
@IdClass(TcWcells.PrimaryKeys.class)
public class TcWcells implements Serializable {
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