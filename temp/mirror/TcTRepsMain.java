package barakat.app.model.mirror;

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
public class TcTRepsMain implements Serializable {

  @Id
  @Column(name = "\"ID\"", nullable = false)
  private Integer id;
  @Column(name = "\"NAME\"", nullable = false)
  private String name;
  @Column(name = "\"NOTES\"", nullable = true)
  private String notes;
  @Column(name = "\"DATE_FROM\"", nullable = true)
  private Timestamp dateFrom;
  @Column(name = "\"DATE_TO\"", nullable = true)
  private Timestamp dateTo;
  @Column(name = "\"DATE_PERIOD\"", nullable = false)
  private Integer datePeriod;
  @Column(name = "\"GROUP_BY\"", nullable = false)
  private Integer groupBy;
  @Column(name = "\"FILTER_BY\"", nullable = false)
  private Integer filterBy;
}