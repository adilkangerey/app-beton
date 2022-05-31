package barakat.app.aggregator.entity.app.model.mirror;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Таблица данных о зафиксированных изображениях
 */
@Data
@Entity
@Table
public class TcWimages implements Serializable {

  @Id
  @Column(name = "\"ID\"", nullable = false)
  private Integer id;
  /**
   * Код записи в таблице wUnits
   */
  @Column(name = "\"wUnitsLink\"", nullable = false)
  private Integer wunitslink;
  /**
   * Дата и время фиксации
   */
  @Column(name = "\"At\"", nullable = false)
  private Timestamp at;
  /**
   * Номер камеры, с которой были сделаны изображения (1...n)
   */
  @Column(name = "\"CameraNo\"", nullable = false)
  private Short camerano;
  /**
   * Изображение
   */
  @Column(name = "\"Img\"", nullable = false)
  private String img;
  /**
   * Номер взвешивания (1..2)
   */
  @Column(name = "\"WeighNo\"", nullable = false)
  private Short weighno;
  /**
   * Автоматич. распознанный номер
   */
  @Column(name = "\"TranspNo\"", nullable = true)
  private String transpno;
  /**
   * Наиболее верятный номер
   */
  @Column(name = "\"BestGuess\"", nullable = true)
  private String bestguess;
  /**
   * Альтернативный вариант предположения о номере транспорта
   */
  @Column(name = "\"AltGuess\"", nullable = true)
  private String altguess;
  /**
   * Качество распознавания (0..100)
   */
  @Column(name = "\"Quality\"", nullable = true)
  private java.math.BigDecimal quality;
}