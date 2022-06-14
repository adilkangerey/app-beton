package barakat.app.model.mirror;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Список складов
 */
@Data
@Entity
@Table
public class TcBkwarehouses implements Serializable {

  @Id
  @Column(name = "\"ID\"", nullable = false)
  private Integer id;
  @Column(name = "\"Name\"", nullable = false)
  private String name;
  @Column(name = "\"Enabled\"", nullable = false)
  private Short enabled;
  @Column(name = "\"CustomerLink\"", nullable = true)
  private Integer customerlink;
  @Column(name = "\"Notes\"", nullable = true)
  private String notes;
}