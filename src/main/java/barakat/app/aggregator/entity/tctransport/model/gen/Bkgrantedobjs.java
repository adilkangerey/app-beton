package barakat.app.aggregator.entity.tctransport.model.gen;

import java.io.Serializable;
import java.sql.*;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity(name = "barakat.app.aggregator.entity.tctransport.model.gen.Bkgrantedobjs")
@Table(name = "bkGrantedObjs")
public class Bkgrantedobjs implements Serializable {

  @Id
  @Column(name = "\"ID\"", nullable = false)
  private Integer id;
  @Column(name = "\"Name\"", nullable = false)
  private String name;
  @Column(name = "\"Description\"", nullable = true)
  private String description;
}