package barakat.tctransport.model.gen;

import java.io.Serializable;
import java.sql.*;
import javax.persistence.*;
import lombok.Data;

/**
 * Движение средств на объектах
 */
@Data
@Entity(name = "barakat.app.aggregator.entity.tctransport.model.gen.Regmoneys")
@Table(name = "RegMoneys")
public class Regmoneys implements Serializable {

  @Id
  @Column(name = "\"ID\"", nullable = false)
  private Integer id;
  @Column(name = "\"At\"", nullable = false)
  private Timestamp at;
  @Column(name = "\"CustomerFrom\"", nullable = true)
  private Integer customerfrom;
  @Column(name = "\"WHouseFrom\"", nullable = true)
  private Integer whousefrom;
  @Column(name = "\"Value\"", nullable = false)
  private Double value;
  @Column(name = "\"CreatedAt\"", nullable = true)
  private Timestamp createdat;
  @Column(name = "\"CreatorLink\"", nullable = true)
  private Integer creatorlink;
  @Column(name = "\"EditAt\"", nullable = true)
  private Timestamp editat;
  @Column(name = "\"EditorLink\"", nullable = true)
  private Integer editorlink;
  @Column(name = "\"Reason\"", nullable = true)
  private String reason;
  @Column(name = "\"IsDebit\"", nullable = false)
  private Short isdebit;
}