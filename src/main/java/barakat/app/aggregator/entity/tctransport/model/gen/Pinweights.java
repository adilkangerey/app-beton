package barakat.app.aggregator.entity.tctransport.model.gen;

import java.io.Serializable;
import java.sql.*;
import javax.persistence.*;
import lombok.Data;

/**
 * Данные по инвентаризации по остаткам товаров на складе \ территории клиента.
 * Используются для ускорения расчета остатков.
 */
@Data
@Entity(name = "barakat.app.aggregator.entity.tctransport.model.gen.Pinweights")
@Table(name = "PinWeights")
public class Pinweights implements Serializable {

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