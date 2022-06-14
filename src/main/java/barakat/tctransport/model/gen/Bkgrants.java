package barakat.tctransport.model.gen;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

/**
 * Права доступа операторов
 */
@Data
@Entity(name = "barakat.app.aggregator.entity.tctransport.model.gen.Bkgrants")
@Table(name = "bkGrants")
@IdClass(Bkgrants.PrimaryKeys.class)
public class Bkgrants implements Serializable {
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