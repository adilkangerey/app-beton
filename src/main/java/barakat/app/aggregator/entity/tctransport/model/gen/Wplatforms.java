package barakat.app.aggregator.entity.tctransport.model.gen;

import java.io.Serializable;
import java.sql.*;
import javax.persistence.*;
import lombok.Data;

/**
 * Данные о весе на платформах, участвующих во взвешивании
 */
@Data
@Entity(name = "barakat.app.aggregator.entity.tctransport.model.gen.Wplatforms")
@Table(name = "wPlatforms")
public class Wplatforms implements Serializable {

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