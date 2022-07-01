package barakat.tctransport.model.gen;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

/**
 * Описания таблиц, на которые есть ссылки из bkMKeys
 */
@Data
@Entity(name = "barakat.app.aggregator.entity.tctransport.model.gen.Bkmktables")
@Table(name = "bkMKTables")
public class Bkmktables implements Serializable {

  @Id
  @Column(name = "\"ID\"", nullable = false)
  private Integer id;
  /**
   * Названия элементов во всех справочниках
   */
  @Column(name = "\"Name\"", nullable = false)
  private String name;
  @Column(name = "\"StrID\"", nullable = false)
  private String strid;
}