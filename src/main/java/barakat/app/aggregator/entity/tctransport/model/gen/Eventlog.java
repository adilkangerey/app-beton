package barakat.app.aggregator.entity.tctransport.model.gen;

import java.io.Serializable;
import java.sql.*;
import javax.persistence.*;
import lombok.Data;

/**
 * Журнал событий программы
 */
@Data
@Entity(name = "barakat.app.aggregator.entity.tctransport.model.gen.Eventlog")
@Table(name = "EventLog")
public class Eventlog implements Serializable {

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