package barakat.app.aggregator.entity.tctransport.model.gen;

import java.io.Serializable;
import java.sql.*;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity(name = "barakat.app.aggregator.entity.tctransport.model.gen.Wlogimages")
@Table(name = "WLogImages")
@IdClass(Wlogimages.PrimaryKeys.class)
public class Wlogimages implements Serializable {
  @Data
  public static class PrimaryKeys implements Serializable {
    private Integer wloglink;
    private Integer camno;
  }

  @Id
  @Column(name = "\"WLogLink\"", nullable = false)
  private Integer wloglink;
  @Id
  @Column(name = "\"CamNo\"", nullable = false)
  private Integer camno;
  @Column(name = "\"Img\"", nullable = false)
  private String img;
}