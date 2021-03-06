package barakat.tctransport.model.gen;

import java.io.Serializable;
import java.sql.*;
import javax.persistence.*;
import lombok.Data;

/**
 * Данные о движении товаров.
 */
@Data
@Entity(name = "barakat.app.aggregator.entity.tctransport.model.gen.Regweights")
@Table(name = "RegWeights")
public class Regweights implements Serializable {

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