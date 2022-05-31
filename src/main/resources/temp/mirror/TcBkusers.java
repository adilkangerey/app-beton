package barakat.app.aggregator.entity.app.model.mirror;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Список пользователей программы
 */
@Data
@Entity
@Table
public class TcBkusers implements Serializable {

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
  @Column(name = "\"GroupLink\"", nullable = false)
  private Integer grouplink;
  @Column(name = "\"Password\"", nullable = true)
  private String password;
  @Column(name = "\"Notes\"", nullable = true)
  private String notes;
  /**
   * Должность
   */
  @Column(name = "\"Appointment\"", nullable = true)
  private String appointment;
}