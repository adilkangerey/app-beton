package barakat.tctransport.model.gen;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity(name = "barakat.app.aggregator.entity.tctransport.model.gen.TrashRecs")
@Table(name = "TRASH_RECS")
public class TrashRecs implements Serializable {

  @Id
  @Column(name = "\"ID\"", nullable = false)
  private Integer id;
  @Column(name = "\"IsUpdated\"", nullable = false)
  private Short isupdated;
}