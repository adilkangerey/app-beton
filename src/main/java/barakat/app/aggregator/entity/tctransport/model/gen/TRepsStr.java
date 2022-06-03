package barakat.app.aggregator.entity.tctransport.model.gen;

import java.io.Serializable;
import java.sql.*;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity(name = "barakat.app.aggregator.entity.tctransport.model.gen.TRepsStr")
@Table(name = "T_REPS_STR")
@IdClass(TRepsStr.PrimaryKeys.class)
public class TRepsStr implements Serializable {
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