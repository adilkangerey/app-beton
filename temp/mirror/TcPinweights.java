package barakat.app.aggregator.entity.app.model.mirror;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Данные по инвентаризации по остаткам товаров на складе \ территории клиента.
 * Используются для ускорения расчета остатков.
 */
@Data
@Entity
@Table
public class TcPinweights implements Serializable {

  @Id
  @Column(name = "\"ID\"", nullable = false)
  private Integer id;
  /**
   * клиент
   */
  @Column(name = "\"CustomerLink\"", nullable = false)
  private Integer customerlink;
  /**
   * материал
   */
  @Column(name = "\"ProductLink\"", nullable = false)
  private Integer productlink;
  /**
   * дата
   */
  @Column(name = "\"At\"", nullable = false)
  private Timestamp at;
  /**
   * автор
   */
  @Column(name = "\"CreatorLink\"", nullable = false)
  private Integer creatorlink;
  /**
   * склад
   */
  @Column(name = "\"WareHouseLink\"", nullable = true)
  private Integer warehouselink;
  @Column(name = "\"Weight\"", nullable = false)
  private Integer weight;
  @Column(name = "\"CreatedAt\"", nullable = false)
  private Timestamp createdat;
  @Column(name = "\"EditorLink\"", nullable = true)
  private Integer editorlink;
  @Column(name = "\"EditAt\"", nullable = true)
  private Timestamp editat;
  @Column(name = "\"Notes\"", nullable = true)
  private String notes;
}