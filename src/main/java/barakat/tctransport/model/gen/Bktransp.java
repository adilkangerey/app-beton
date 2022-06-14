package barakat.tctransport.model.gen;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

/**
 * Список собственного транспорта
 * 
 * 18-02-2022
 * добавлены поля VEHICLE_VOLUME \ TRAILER_VOLUME
 */
@Data
@Entity(name = "barakat.app.aggregator.entity.tctransport.model.gen.Bktransp")
@Table(name = "bkTransp")
public class Bktransp implements Serializable {

  @Id
  @Column(name = "\"ID\"", nullable = false)
  private Integer id;
  @Column(name = "\"Enabled\"", nullable = false)
  private Short enabled;
  /**
   * Номер транспорта
   */
  @Column(name = "\"TranspNum\"", nullable = false)
  private String transpnum;
  /**
   * Вес автомобиля
   */
  @Column(name = "\"Weight\"", nullable = false)
  private Integer weight;
  /**
   * Вес прицепа
   */
  @Column(name = "\"TrWeight\"", nullable = true)
  private Integer trweight;
  /**
   * Необходимое количество взвешиваний для автомобиля
   */
  @Column(name = "\"RecsCount\"", nullable = false)
  private Integer recscount;
  /**
   * Количество взвешиваний для прицепа
   */
  @Column(name = "\"TrRecsCount\"", nullable = true)
  private Integer trrecscount;
  /**
   * Водитель ФИО
   */
  @Column(name = "\"Driver\"", nullable = true)
  private String driver;
  /**
   * Модель транспорта
   */
  @Column(name = "\"TranspType\"", nullable = true)
  private String transptype;
  /**
   * Код продукта по умолчанию
   */
  @Column(name = "\"CargoLink\"", nullable = true)
  private Integer cargolink;
  /**
   * Код поставщика
   */
  @Column(name = "\"SupplierLink\"", nullable = true)
  private Integer supplierlink;
  /**
   * Код заказчика
   */
  @Column(name = "\"CustomerLink\"", nullable = true)
  private Integer customerlink;
  /**
   * Код перевозчика
   */
  @Column(name = "\"FerrymanLink\"", nullable = true)
  private Integer ferrymanlink;
  /**
   * Код плательщика
   */
  @Column(name = "\"CashierLink\"", nullable = true)
  private Integer cashierlink;
  @Column(name = "\"Notes\"", nullable = true)
  private String notes;
  /**
   * Идентификатор карточки (магнитной или RF)
   */
  @Column(name = "\"CardId\"", nullable = true)
  private String cardid;
  /**
   * Номер прицепа
   */
  @Column(name = "\"TrailerNum\"", nullable = true)
  private String trailernum;
  /**
   * Тип транспорта (bkTranspMain)
   */
  @Column(name = "\"TranspLink\"", nullable = true)
  private Integer transplink;
  /**
   * Код склада погрузки
   */
  @Column(name = "\"WarehouseLink\"", nullable = true)
  private Integer warehouselink;
  /**
   * Код склада разгрузки
   */
  @Column(name = "\"WarehouseOutLink\"", nullable = true)
  private Integer warehouseoutlink;
  /**
   * Тип автофиксации:
   * 0 - по умолчанию, как указано в осн настройках программы
   * 1 - фиксация брутто и тары, без контроля нетто
   * 2 - фиксация брутто и тары с контролем отклонения нетто
   */
  @Column(name = "\"AUTO_FIX_MODE\"", nullable = false)
  private Integer autoFixMode;
  /**
   * Вес нетто для контроля отклонения при AUTO_FIX_MODE=3
   */
  @Column(name = "\"NETTO_BY_DOC\"", nullable = true)
  private Integer nettoByDoc;
  /**
   * Максимальное отклонение реального веса нетто от указанного в NETTO_BY_DOC при AUT_FIX_MODE=3
   */
  @Column(name = "\"NETTO_DELTA\"", nullable = true)
  private Integer nettoDelta;
  @Column(name = "\"VEHICLE_VOLUME\"", nullable = true)
  private java.math.BigDecimal vehicleVolume;
  @Column(name = "\"TRAILER_VOLUME\"", nullable = true)
  private java.math.BigDecimal trailerVolume;
  @Column(name = "\"SHORT_PLATE\"", nullable = true)
  private String shortPlate;
}