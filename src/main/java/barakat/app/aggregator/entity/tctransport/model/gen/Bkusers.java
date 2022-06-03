package barakat.app.aggregator.entity.tctransport.model.gen;

import java.io.Serializable;
import java.sql.*;
import javax.persistence.*;
import lombok.Data;

/**
 * Список пользователей программы
 */
@Data
@Entity(name = "barakat.app.aggregator.entity.tctransport.model.gen.Bkusers")
@Table(name = "bkUsers")
public class Bkusers implements Serializable {

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