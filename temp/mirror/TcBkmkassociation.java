package barakat.app.aggregator.entity.app.model.mirror;

import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table
@IdClass(TcBkmkassociation.PrimaryKeys.class)
public class TcBkmkassociation implements Serializable {
  @Data
  public static class PrimaryKeys implements Serializable {
    private Integer mklink;
    private Integer extid;
    private String mkey;
  }

  @Id
  @Column(name = "\"MKLink\"", nullable = false)
  private Integer mklink;
  @Id
  @Column(name = "\"ExtID\"", nullable = false)
  private Integer extid;
  @Id
  @Column(name = "\"MKey\"", nullable = false)
  private String mkey;
}