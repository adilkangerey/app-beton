package barakat.app.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


@Data
@Entity
@Table(name = "appDrivers")
public class AppDrivers implements Serializable {
  @Id
  @Column(nullable = false)
  private Integer id;
  private Integer bkTranspId;
  @Column(nullable = false)
  private String name;
  @Column(nullable = false)
  private Boolean enabled;
  private String telegramChatId;
  private String phoneNumbers;
}