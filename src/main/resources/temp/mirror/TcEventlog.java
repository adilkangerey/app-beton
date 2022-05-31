package barakat.app.aggregator.entity.app.model.mirror;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Журнал событий программы
 */
@Data
@Entity
@Table
public class TcEventlog implements Serializable {

  @Id
  @Column(name = "\"ID\"", nullable = false)
  private Integer id;
  /**
   * 1 - добавление, 2 - изменение, 3 - удаление. Отслеживаются автоматич сервером БД
   * 10..50 - события клиента:
   * 10 - начало работы, 11 - окончание
   * 20 - начало работы оператора, 21 - окончание
   */
  @Column(name = "\"Group\"", nullable = false)
  private Integer group;
  /**
   * Описание события
   */
  @Column(name = "\"Descr\"", nullable = false)
  private String descr;
  @Column(name = "\"At\"", nullable = false)
  private Timestamp at;
  @Column(name = "\"Host\"", nullable = false)
  private String host;
  @Column(name = "\"UserName\"", nullable = false)
  private String username;
}