package barakat.app.entity.mirror;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table
public class TcBkgrantedobjs implements Serializable {

  @Id
  @Column(name = "\"ID\"", nullable = false)
  private Integer id;
  @Column(name = "\"Name\"", nullable = false)
  private String name;
  @Column(name = "\"Description\"", nullable = true)
  private String description;
}