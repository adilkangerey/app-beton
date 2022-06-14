package barakat.app.model.mirror;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Данные о взвешивании на весах - разовое или поосное, неважно. В случае
 * поосного взвешивания фиксируется несколько записей в таблице.
 * В случае многоплатформенных весов или независимых датчиков данные
 * сохраняются соответственно в wPlatforms \ wCells.
 */
@Data
@Entity
@Table
public class TcWscales implements Serializable {

  @Id
  @Column(name = "\"ID\"", nullable = false)
  private Integer id;
  @Column(name = "\"wUnitsLink\"", nullable = false)
  private Integer wunitslink;
  @Column(name = "\"At\"", nullable = false)
  private Timestamp at;
  /**
   * Номер весов (1..n)
   */
  @Column(name = "\"ScalesNo\"", nullable = false)
  private Short scalesno;
  /**
   * Вес
   */
  @Column(name = "\"Weight\"", nullable = false)
  private Integer weight;
  /**
   * Номер взвешивания (1..2)
   */
  @Column(name = "\"WeighNo\"", nullable = false)
  private Short weighno;
  /**
   * Тип взвешивания:
   * 0 - вручную
   * 1 - автоматически
   * 2 - копия данных о собств. транспорте
   * 3 - копия взвешивания тары
   * 4 - копия взвешивания брутто
   * 5 - с ручным вводом тары
   * 6 - автофиксация данных
   * 7 - добавление вручную веса чистого продукта
   */
  @Column(name = "\"WType\"", nullable = false)
  private Short wtype;
  /**
   * Скорость (м\с) транспорта в момент взвешивания
   */
  @Column(name = "\"Speed\"", nullable = true)
  private Float speed;
  /**
   * Расстояние (м) до предыдущей взвешенной оси
   */
  @Column(name = "\"PrevAxisLen\"", nullable = true)
  private Float prevaxislen;
  @Column(name = "\"TranspDirection\"", nullable = true)
  private Integer transpdirection;
}