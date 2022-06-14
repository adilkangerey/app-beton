package barakat.app.model.mirror;

import lombok.Data;

import java.io.Serializable;

/**
 * Права доступа операторов
 */
@Data
@Entity
@Table
@IdClass(TcBkgrants.PrimaryKeys.class)
public class TcBkgrants implements Serializable {
  @Data
  public static class PrimaryKeys implements Serializable {
    private Integer usergrouplink;
    private Integer grantedobjlink;
  }

  @Id
  @Column(name = "\"UserGroupLink\"", nullable = false)
  private Integer usergrouplink;
  @Id
  @Column(name = "\"GrantedObjLink\"", nullable = false)
  private Integer grantedobjlink;
  @Column(name = "\"Value\"", nullable = false)
  private Long value;
}