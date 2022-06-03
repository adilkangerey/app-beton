package barakat.app.aggregator.entity.tctransport.model.gen;

import java.io.Serializable;
import java.sql.*;
import javax.persistence.*;
import lombok.Data;

/**
 * Материалы
 */
@Data
@Entity(name = "barakat.app.aggregator.entity.tctransport.model.gen.Bkproducts")
@Table(name = "bkProducts")
public class Bkproducts implements Serializable {

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