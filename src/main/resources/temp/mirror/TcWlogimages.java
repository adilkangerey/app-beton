package barakat.app.aggregator.entity.app.model.mirror;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table
@IdClass(TcWlogimages.PrimaryKeys.class)
public class TcWlogimages implements Serializable {
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