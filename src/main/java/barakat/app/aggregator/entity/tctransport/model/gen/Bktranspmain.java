package barakat.app.aggregator.entity.tctransport.model.gen;

import java.io.Serializable;
import java.sql.*;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity(name = "barakat.app.aggregator.entity.tctransport.model.gen.Bktranspmain")
@Table(name = "bkTranspMain")
public class Bktranspmain implements Serializable {

  @Id
  @Column(name = "\"ID\"", nullable = false)
  private Integer id;
  @Column(name = "\"Name\"", nullable = true)
  private String name;
  /**
   * Группа ТС
   */
  @Column(name = "\"TranspGroupLink\"", nullable = true)
  private Integer transpgrouplink;
  /**
   * Грузоподъемность
   */
  @Column(name = "\"CapacityTypeLink\"", nullable = true)
  private Integer capacitytypelink;
  /**
   * Тип осевых нагрузок
   */
  @Column(name = "\"AxleWeightLoadLink\"", nullable = true)
  private Integer axleweightloadlink;
  /**
   * Кол-во осей
   */
  @Column(name = "\"AxleCount\"", nullable = true)
  private Integer axlecount;
  /**
   * Ширина ТС, см
   */
  @Column(name = "\"TranspWidth\"", nullable = true)
  private Integer transpwidth;
  /**
   * Длина ТС, см
   */
  @Column(name = "\"TranspLength\"", nullable = true)
  private Integer transplength;
  /**
   * Высота ТС, см
   */
  @Column(name = "\"TranspHeight\"", nullable = true)
  private Integer transpheight;
  /**
   * Собственный вес, кг
   */
  @Column(name = "\"Tare\"", nullable = true)
  private Integer tare;
  /**
   * Максим отклонения центра тяжести по ширине, см
   */
  @Column(name = "\"COGDeltaWidth\"", nullable = true)
  private Integer cogdeltawidth;
  /**
   * Максим отклонения центра тяжести по длине, см
   */
  @Column(name = "\"COGDeltaLength\"", nullable = true)
  private Integer cogdeltalength;
  /**
   * Грузоподъемность, кг
   * Если не указана, берется из справочника CapacityTypes
   */
  @Column(name = "\"Capacity\"", nullable = true)
  private Integer capacity;
  /**
   * Максимальный перегруз, кг
   * Если не указан, берется из CapacityTypes
   */
  @Column(name = "\"MaxOverweight\"", nullable = true)
  private Integer maxoverweight;
}