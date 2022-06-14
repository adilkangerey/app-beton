package barakat.app.model.mirror;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Движение средств на объектах
 */
@Data
@Entity
@Table
public class TcRegmoneys implements Serializable {

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