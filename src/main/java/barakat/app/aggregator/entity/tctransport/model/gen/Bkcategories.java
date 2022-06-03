package barakat.app.aggregator.entity.tctransport.model.gen;

import java.io.Serializable;
import java.sql.*;
import javax.persistence.*;
import lombok.Data;

/**
 * Категории товаров
 */
@Data
@Entity(name = "barakat.app.aggregator.entity.tctransport.model.gen.Bkcategories")
@Table(name = "bkCategories")
public class Bkcategories implements Serializable {

  @Id
  @Column(name = "\"ID\"", nullable = false)
  private Integer id;
  /**
   * Названия элементов во всех справочниках
   */
  @Column(name = "\"Name\"", nullable = false)
  private String name;
  @Column(name = "\"Enabled\"", nullable = false)
  private Short enabled;
  @Column(name = "\"SName\"", nullable = true)
  private String sname;
}