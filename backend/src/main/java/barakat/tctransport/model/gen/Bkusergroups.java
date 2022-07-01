package barakat.tctransport.model.gen;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity(name = "barakat.app.aggregator.entity.tctransport.model.gen.Bkusergroups")
@Table(name = "bkUserGroups")
public class Bkusergroups implements Serializable {

  @Id
  @Column(name = "\"ID\"", nullable = false)
  private Integer id;
  /**
   * Названия элементов во всех справочниках
   */
  @Column(name = "\"Name\"", nullable = false)
  private String name;
}