package barakat.app.aggregator.entity.tctransport.model.gen;

import java.io.Serializable;
import java.sql.*;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity(name = "barakat.app.aggregator.entity.tctransport.model.gen.TRepsMain")
@Table(name = "T_REPS_MAIN")
public class TRepsMain implements Serializable {

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