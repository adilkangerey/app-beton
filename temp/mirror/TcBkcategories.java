package barakat.app.entity.mirror;

import barakat.tctransport.interf.BkcategoriesInterf;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Категории товаров
 */
@Data
@Entity
@Table
public class TcBkcategories implements Serializable, BkcategoriesInterf {

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