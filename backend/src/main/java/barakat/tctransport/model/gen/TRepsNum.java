package barakat.tctransport.model.gen;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity(name = "barakat.app.aggregator.entity.tctransport.model.gen.TRepsNum")
@Table(name = "T_REPS_NUM")
@IdClass(TRepsNum.PrimaryKeys.class)
public class TRepsNum implements Serializable {
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