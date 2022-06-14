package barakat.app.model.mirror;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Данные о движении товаров.
 */
@Data
@Entity
@Table
public class TcRegweights implements Serializable {

  @Id
  @Column(name = "\"ID\"", nullable = false)
  private Integer id;
  @Column(name = "\"At\"", nullable = false)
  private Timestamp at;
  /**
   * Код оператора, выполнившего операцию
   */
  @Column(name = "\"CreatorLink\"", nullable = false)
  private Integer creatorlink;
  @Column(name = "\"Weight\"", nullable = false)
  private Integer weight;
  @Column(name = "\"CustomerFrom\"", nullable = true)
  private Integer customerfrom;
  @Column(name = "\"CustomerTo\"", nullable = true)
  private Integer customerto;
  @Column(name = "\"WHouseFrom\"", nullable = true)
  private Integer whousefrom;
  @Column(name = "\"WHouseTo\"", nullable = true)
  private Integer whouseto;
  @Column(name = "\"ProductLink\"", nullable = false)
  private Integer productlink;
  @Column(name = "\"EditorLink\"", nullable = true)
  private Integer editorlink;
  @Column(name = "\"EditAt\"", nullable = true)
  private Timestamp editat;
  @Column(name = "\"Notes\"", nullable = true)
  private String notes;
}