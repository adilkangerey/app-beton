package barakat.app.aggregator.entity.tctransport.model.gen;

import java.io.Serializable;
import java.sql.*;
import javax.persistence.*;
import lombok.Data;

/**
 * Сведения о транспортной единице (авто, прицеп...)
 */
@Data
@Entity(name = "barakat.app.aggregator.entity.tctransport.model.gen.Wunits")
@Table(name = "wUnits")
public class Wunits implements Serializable {

  @Id
  @Column(name = "\"ID\"", nullable = false)
  private Integer id;
  /**
   * Ссылка на родительскую запись (wMain)
   */
  @Column(name = "\"wMainLink\"", nullable = true)
  private Integer wmainlink;
  @Column(name = "\"W1\"", nullable = false)
  private Integer w1;
  @Column(name = "\"W2\"", nullable = true)
  private Integer w2;
  @Column(name = "\"Netto\"", nullable = true)
  private Long netto;
  @Column(name = "\"W1At\"", nullable = false)
  private Timestamp w1at;
  @Column(name = "\"W2At\"", nullable = true)
  private Timestamp w2at;
  /**
   * Номер транспорта
   */
  @Column(name = "\"TranspNum\"", nullable = false)
  private String transpnum;
  /**
   * 0 - автомобиль
   * 1..n - прицепы
   */
  @Column(name = "\"UnitNo\"", nullable = false)
  private Short unitno;
  /**
   * Номер накладной
   */
  @Column(name = "\"InvoiceNum\"", nullable = true)
  private String invoicenum;
  /**
   * Серия накладной
   */
  @Column(name = "\"InvoiceSeria\"", nullable = true)
  private String invoiceseria;
  /**
   * Путевой лист
   */
  @Column(name = "\"RoadDoc\"", nullable = true)
  private String roaddoc;
  /**
   * Температура транспорта при первом взвешивании
   */
  @Column(name = "\"Temper1\"", nullable = true)
  private java.math.BigDecimal temper1;
  /**
   * Температура транспорта при втором взвешивании
   */
  @Column(name = "\"Temper2\"", nullable = true)
  private java.math.BigDecimal temper2;
}