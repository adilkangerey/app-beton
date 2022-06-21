package barakat.app.entity.mirror;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;

@Data
@Entity
@Table
public class TcFxlog implements Serializable {

  @Id
  @Column(name = "\"ID\"", nullable = false)
  private Integer id;
  @Column(name = "\"At\"", nullable = false)
  private Timestamp at;
  @Column(name = "\"Weight\"", nullable = false)
  private Integer weight;
  @Column(name = "\"ScNo\"", nullable = false)
  private Integer scno;
  @Column(name = "\"WPointLink\"", nullable = false)
  private Integer wpointlink;
  @Column(name = "\"MKey\"", nullable = true)
  private String mkey;
  @Column(name = "\"RecType\"", nullable = false)
  private Integer rectype;
  @Column(name = "\"Driver\"", nullable = true)
  private String driver;
  @Column(name = "\"TranspNum\"", nullable = true)
  private String transpnum;
  @Column(name = "\"Plates\"", nullable = true)
  private String plates;
  @Column(name = "\"TrailerNum\"", nullable = true)
  private String trailernum;
  @Column(name = "\"CamNo1\"", nullable = true)
  private Integer camno1;
  @Column(name = "\"CamNo2\"", nullable = true)
  private Integer camno2;
  @Column(name = "\"axCount\"", nullable = true)
  private Integer axcount;
  @Column(name = "\"ax01\"", nullable = true)
  private Integer ax01;
  @Column(name = "\"ax02\"", nullable = true)
  private Integer ax02;
  @Column(name = "\"ax03\"", nullable = true)
  private Integer ax03;
  @Column(name = "\"ax04\"", nullable = true)
  private Integer ax04;
  @Column(name = "\"ax05\"", nullable = true)
  private Integer ax05;
  @Column(name = "\"ax06\"", nullable = true)
  private Integer ax06;
  @Column(name = "\"ax07\"", nullable = true)
  private Integer ax07;
  @Column(name = "\"ax08\"", nullable = true)
  private Integer ax08;
  @Column(name = "\"ax09\"", nullable = true)
  private Integer ax09;
  @Column(name = "\"ax10\"", nullable = true)
  private Integer ax10;
  @Column(name = "\"AUTO_FIX_MODE\"", nullable = true)
  private Integer autoFixMode;
  @Column(name = "\"NETTO_BY_DOC\"", nullable = true)
  private Integer nettoByDoc;
  @Column(name = "\"NETTO_DELTA\"", nullable = true)
  private Integer nettoDelta;
  @Column(name = "\"REC_TYPE\"", nullable = true)
  private Integer recType;
  /**
   * Активный оператор в момент фиксации
   */
  @Column(name = "\"USER_ID\"", nullable = true)
  private Integer userId;
  @Column(name = "\"NUM_TYPE_1\"", nullable = true)
  private String numType1;
  @Column(name = "\"NUM_TYPE_2\"", nullable = true)
  private String numType2;
}