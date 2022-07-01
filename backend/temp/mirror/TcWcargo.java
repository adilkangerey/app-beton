package barakat.app.entity.mirror;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Данные о грузе для единицы транспорта
 */
@Data
@Entity
@Table
public class TcWcargo implements Serializable {

  @Id
  @Column(name = "\"ID\"", nullable = false)
  private Integer id;
  /**
   * Ссылка на запись единицы транспорта (wUnits)
   */
  @Column(name = "\"wUnitsLink\"", nullable = false)
  private Integer wunitslink;
  /**
   * Продукт
   */
  @Column(name = "\"ProductLink\"", nullable = true)
  private Integer productlink;
  /**
   * Заказчик
   */
  @Column(name = "\"CustomerLink\"", nullable = true)
  private Integer customerlink;
  /**
   * Поставщик
   */
  @Column(name = "\"VendorLink\"", nullable = true)
  private Integer vendorlink;
  /**
   * Перевозчик
   */
  @Column(name = "\"TransporterLink\"", nullable = true)
  private Integer transporterlink;
  /**
   * Плательщик
   */
  @Column(name = "\"PayerLink\"", nullable = true)
  private Integer payerlink;
  /**
   * Код пункта погрузки
   */
  @Column(name = "\"WarehouseLink\"", nullable = true)
  private Integer warehouselink;
  /**
   * Чистый вес груза по накладной
   */
  @Column(name = "\"Weight\"", nullable = true)
  private Integer weight;
  /**
   * Код пункта разгрузки
   */
  @Column(name = "\"WarehouseOutLink\"", nullable = true)
  private Integer warehouseoutlink;
  /**
   * Цена на момент взвешивания. Берется либо с Price либо с PriceV продукта, в зависимости от RecalcByV
   */
  @Column(name = "\"Price\"", nullable = true)
  private Integer price;
  /**
   * % сорности * 100
   */
  @Column(name = "\"Garbage\"", nullable = true)
  private Integer garbage;
  /**
   * категория товара
   */
  @Column(name = "\"CategoryLink\"", nullable = true)
  private Integer categorylink;
  /**
   * Вес тары по накладной
   */
  @Column(name = "\"TareByDoc\"", nullable = true)
  private Integer tarebydoc;
  /**
   * Брутто по накладной
   */
  @Column(name = "\"BruttoByDoc\"", nullable = true)
  private Integer bruttobydoc;
  /**
   * Объемный коэффициент продукта на момент взвешивания
   */
  @Column(name = "\"VCoef\"", nullable = false)
  private java.math.BigDecimal vcoef;
  /**
   * Стоимость объема на момент взвешивания
   */
  @Column(name = "\"VPrice\"", nullable = false)
  private Integer vprice;
  @Column(name = "\"RecalcByV\"", nullable = false)
  private Short recalcbyv;
}