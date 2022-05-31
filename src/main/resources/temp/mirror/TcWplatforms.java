package barakat.app.aggregator.entity.app.model.mirror;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Данные о весе на платформах, участвующих во взвешивании
 */
@Data
@Entity
@Table
public class TcWplatforms implements Serializable {

  @Id
  @Column(name = "\"ID\"", nullable = false)
  private Integer id;
  @Column(name = "\"wScalesLink\"", nullable = false)
  private Integer wscaleslink;
  /**
   * Номер платформы (1..n)
   */
  @Column(name = "\"PlatformNo\"", nullable = false)
  private Short platformno;
  @Column(name = "\"Weight\"", nullable = false)
  private Integer weight;
}