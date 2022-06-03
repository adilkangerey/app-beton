package barakat.app.aggregator.entity.tctransport.model.gen;

import java.io.Serializable;
import java.sql.*;
import javax.persistence.*;
import lombok.Data;

/**
 * Список клиентов
 */
@Data
@Entity(name = "barakat.app.aggregator.entity.tctransport.model.gen.Bkcustomers")
@Table(name = "bkCustomers")
public class Bkcustomers implements Serializable {

  @Id
  @Column(name = "\"ID\"", nullable = false)
  private Integer id;
  /**
   * Названия элементов во всех справочниках
   */
  @Column(name = "\"Name\"", nullable = false)
  private String name;
  @Column(name = "\"Enabled\"", nullable = false)
  private Short enabled;
  @Column(name = "\"Address\"", nullable = true)
  private String address;
  @Column(name = "\"Notes\"", nullable = true)
  private String notes;
  @Column(name = "\"INN\"", nullable = false)
  private String inn;
  @Column(name = "\"KPP\"", nullable = false)
  private String kpp;
  @Column(name = "\"OGRN\"", nullable = false)
  private String ogrn;
  @Column(name = "\"EGRUL\"", nullable = false)
  private String egrul;
  /**
   * Сжатое представление для поиска одинаковых названий
   */
  @Column(name = "\"NAME_HASH\"", nullable = false)
  private String nameHash;
}