package barakat.tctransport.model.gen;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity(name = "barakat.app.aggregator.entity.tctransport.model.gen.Bkmkassociation")
@Table(name = "bkMKAssociation")
@IdClass(Bkmkassociation.PrimaryKeys.class)
public class Bkmkassociation implements Serializable {
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