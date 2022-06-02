package barakat.app.aggregator.entity.app.model.mirror;

import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table
@IdClass(TcTRepsStr.PrimaryKeys.class)
public class TcTRepsStr implements Serializable {
  @Data
  public static class PrimaryKeys implements Serializable {
    private Integer mainId;
    private String id;
    private Integer tid;
  }

  @Id
  @Column(name = "\"MAIN_ID\"", nullable = false)
  private Integer mainId;
  @Id
  @Column(name = "\"ID\"", nullable = false)
  private String id;
  @Id
  @Column(name = "\"TID\"", nullable = false)
  private Integer tid;
}