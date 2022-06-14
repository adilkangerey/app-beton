package barakat.app.model.mirror;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Материалы
 */
@Data
@Entity
@Table
public class TcBkproducts implements Serializable {

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
  @Column(name = "\"Artikul\"", nullable = true)
  private String artikul;
  @Column(name = "\"Preisk\"", nullable = true)
  private String preisk;
  @Column(name = "\"NomenkNo\"", nullable = true)
  private String nomenkno;
  @Column(name = "\"Price\"", nullable = true)
  private Integer price;
  @Column(name = "\"Notes\"", nullable = true)
  private String notes;
  /**
   * Коэффициент пересчета веса в объем
   */
  @Column(name = "\"VCoef\"", nullable = false)
  private java.math.BigDecimal vcoef;
  /**
   * Стоимость 1 куб.м в копейках
   */
  @Column(name = "\"VPrice\"", nullable = false)
  private Integer vprice;
  /**
   * Пересчет стоимости по объемной цене
   */
  @Column(name = "\"RecalcByV\"", nullable = false)
  private Short recalcbyv;
}