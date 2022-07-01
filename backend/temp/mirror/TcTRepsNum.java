package barakat.app.entity.mirror;

import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table
@IdClass(TcTRepsNum.PrimaryKeys.class)
public class TcTRepsNum implements Serializable {
  @Data
  public static class PrimaryKeys implements Serializable {
    private Integer mainId;
    private Integer id;
    private Integer tid;
  }

  @Id
  @Column(name = "\"MAIN_ID\"", nullable = false)
  private Integer mainId;
  @Id
  @Column(name = "\"ID\"", nullable = false)
  private Integer id;
  @Id
  @Column(name = "\"TID\"", nullable = false)
  private Integer tid;
}