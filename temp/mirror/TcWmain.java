package barakat.app.aggregator.entity.app.model.mirror;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * Данные о взвешивании транспорта.
 * Транспорт может состоять из нескольких составных "единиц" - машины и
 * нескольких прицепов (wUnits)
 * Каждая единица описывается данными о грузе (wCargo) и сведениями о
 * взвешиваниях (wWeighs -> wPlatforms -> wCells)
 */
@Data
@Entity
@Table
public class TcWmain implements Serializable {

  @Id
  @Column(name = "\"ID\"", nullable = false)
  private Integer id;
  /**
   * Время первого взвешивания
   */
  @Column(name = "\"W1At\"", nullable = false)
  private Timestamp w1at;
  /**
   * Время второго взвешивания
   */
  @Column(name = "\"W2At\"", nullable = true)
  private Timestamp w2at;
  /**
   * Состояние записи:
   * 0 - первое взвешивание (ручной ввод или полн. определ. номер)
   * 1 - взвешивание завершено
   * 2 - необработ. автоматич. взвешивание
   * 3 - контрольное взвешивание
   */
  @Column(name = "\"State\"", nullable = false)
  private Short state;
  /**
   * Водитель транспорта
   */
  @Column(name = "\"Driver\"", nullable = true)
  private String driver;
  @Column(name = "\"DRIVER_HASH\"", nullable = true)
  private String driverHash;
  /**
   * Номер транспорта, вводимый оператором.
   * Автоматически распознанный номер хранится отдельно для 
   * каждого взвешивания
   */
  @Column(name = "\"TranspNo\"", nullable = false)
  private String transpno;
  @Column(name = "\"TRANSPNO_HASH\"", nullable = true)
  private String transpnoHash;
  /**
   * Ссылка на элемент справочника типов транспорта
   */
  @Column(name = "\"TranspLink\"", nullable = true)
  private Integer transplink;
  /**
   * Тип транспорта:
   * * single \ solid
   * * with trailer \ solid
   * * with trailer \ different
   */
  @Column(name = "\"TranspType\"", nullable = true)
  private String transptype;
  /**
   * Марка автомобиля
   */
  @Column(name = "\"TranspModel\"", nullable = true)
  private String transpmodel;
  @Column(name = "\"TRANSPMODEL_HASH\"", nullable = true)
  private String transpmodelHash;
  @Column(name = "\"W1\"", nullable = false)
  private Integer w1;
  @Column(name = "\"W2\"", nullable = true)
  private Integer w2;
  @Column(name = "\"Netto\"", nullable = true)
  private Long netto;
  @Column(name = "\"User1Link\"", nullable = false)
  private Integer user1link;
  @Column(name = "\"User2Link\"", nullable = true)
  private Integer user2link;
  /**
   * Операторская при первом взвешивании
   */
  @Column(name = "\"WPoint1Link\"", nullable = false)
  private Integer wpoint1link;
  /**
   * Операторская при втором взвешивании
   */
  @Column(name = "\"WPoint2Link\"", nullable = true)
  private Integer wpoint2link;
  /**
   * 0 - создан автоматом
   * 1 - добавлен вручную (брутто\тара)
   * 2 - модифицирован после автом. создания
   * 3 - модифицир после добавления вручную
   * 4 - добавлен вручную (чистый продукт без тары)
   * 6 - модифицировано добавление чистого веса
   */
  @Column(name = "\"EditFlag\"", nullable = false)
  private Short editflag;
  @Column(name = "\"Tare\"", nullable = true)
  private Integer tare;
  @Column(name = "\"Brutto\"", nullable = true)
  private Integer brutto;
  /**
   * Код записи, откуда были скопированы данные для взвешивания за один проход
   * или записи, по которой было сделано контрольное взвешивание (State=3)
   */
  @Column(name = "\"SrcLink\"", nullable = true)
  private Integer srclink;
  /**
   * Тип взвешивания:
   * 0 - вручную
   * 1 - автоматически
   * 2 - копия данных о собств. транспорте
   * 3 - копия взвешивания тары
   * 4 - копия взвешивания брутто
   * 5 - смешанный (одно взвешивание оператор, второе - автоматом)
   */
  @Column(name = "\"WType\"", nullable = false)
  private Short wtype;
  /**
   * Помощник весовщика при первом взвешивании
   */
  @Column(name = "\"SbUser1Link\"", nullable = true)
  private Integer sbuser1link;
  /**
   * Помощник весовщика при втором взвешивании
   */
  @Column(name = "\"SbUser2Link\"", nullable = true)
  private Integer sbuser2link;
  @Column(name = "\"RW1\"", nullable = true)
  private Integer rw1;
  @Column(name = "\"RW2\"", nullable = true)
  private Integer rw2;
  @Column(name = "\"RNetto\"", nullable = true)
  private Long rnetto;
  /**
   * Дополнительный засор - сделал тут а не в Cargo в силу того, что мультипродуктовая загрузка крайне редка
   */
  @Column(name = "\"ExtraGarbWeight\"", nullable = true)
  private Integer extragarbweight;
  /**
   * Общая стоимость груза с учетом мультипродуктовой загрузки
   */
  @Column(name = "\"TotalCost\"", nullable = true)
  private Long totalcost;
  /**
   * Стоимость всего груза с учетом сорности и мультипродуктовой загрузки
   */
  @Column(name = "\"TotalPureCost\"", nullable = true)
  private Long totalpurecost;
  /**
   * Количество отдельных продуктов в кузове автомобиля
   */
  @Column(name = "\"CargoItemCount\"", nullable = true)
  private Integer cargoitemcount;
  /**
   * Общий вес всех продуктов
   */
  @Column(name = "\"CargoWeight\"", nullable = true)
  private Integer cargoweight;
  /**
   * Чистый вес всех продуктов
   */
  @Column(name = "\"CargoPureWeight\"", nullable = true)
  private Integer cargopureweight;
  @Column(name = "\"DovAt\"", nullable = true)
  private Date dovat;
  @Column(name = "\"DovPerson\"", nullable = true)
  private String dovperson;
  @Column(name = "\"DovText\"", nullable = true)
  private String dovtext;
  @Column(name = "\"DovNotes\"", nullable = true)
  private String dovnotes;
  @Column(name = "\"DovNo\"", nullable = true)
  private Integer dovno;
  @Column(name = "\"OrderLink\"", nullable = true)
  private Integer orderlink;
  @Column(name = "\"TrailerNo\"", nullable = true)
  private String trailerno;
  @Column(name = "\"Plates\"", nullable = true)
  private String plates;
  @Column(name = "\"TareByPasp\"", nullable = true)
  private Integer tarebypasp;
  @Column(name = "\"NettoByPasp\"", nullable = true)
  private Integer nettobypasp;
  @Column(name = "\"WReason\"", nullable = true)
  private Integer wreason;
  @Column(name = "\"Notes\"", nullable = true)
  private String notes;
  @Column(name = "\"OwnerLink\"", nullable = true)
  private Integer ownerlink;
  @Column(name = "\"IsDone\"", nullable = true)
  private Integer isdone;
  @Column(name = "\"P1Weight\"", nullable = true)
  private Integer p1weight;
  @Column(name = "\"P2Weight\"", nullable = true)
  private Integer p2weight;
  @Column(name = "\"S1Weight\"", nullable = true)
  private Integer s1weight;
  @Column(name = "\"S2Weight\"", nullable = true)
  private Integer s2weight;
  @Column(name = "\"BelongsTo\"", nullable = true)
  private Integer belongsto;
  @Column(name = "\"ExtF01\"", nullable = true)
  private String extf01;
  @Column(name = "\"ExtF02\"", nullable = true)
  private String extf02;
  @Column(name = "\"ExtF03\"", nullable = true)
  private String extf03;
  @Column(name = "\"ExtF04\"", nullable = true)
  private String extf04;
  @Column(name = "\"ExtF05\"", nullable = true)
  private String extf05;
  @Column(name = "\"W1BeginAt\"", nullable = true)
  private Timestamp w1beginat;
  @Column(name = "\"W2BeginAt\"", nullable = true)
  private Timestamp w2beginat;
  @Column(name = "\"W1NonZeroAt\"", nullable = true)
  private Timestamp w1nonzeroat;
  @Column(name = "\"W2NonZeroAt\"", nullable = true)
  private Timestamp w2nonzeroat;
  @Column(name = "\"IsUpdated\"", nullable = false)
  private Short isupdated;
  @Column(name = "\"ExtF06\"", nullable = true)
  private String extf06;
  @Column(name = "\"ExtF07\"", nullable = true)
  private String extf07;
  @Column(name = "\"ExtF08\"", nullable = true)
  private String extf08;
  @Column(name = "\"EntryAt\"", nullable = true)
  private Timestamp entryat;
  @Column(name = "\"ExitAt\"", nullable = true)
  private Timestamp exitat;
  @Column(name = "\"UserLinkOnExit\"", nullable = true)
  private Integer userlinkonexit;
  @Column(name = "\"CTRL_WEIGHT\"", nullable = true)
  private Integer ctrlWeight;
  @Column(name = "\"CTRL_WPOINT\"", nullable = true)
  private Integer ctrlWpoint;
  @Column(name = "\"CTRL_USER\"", nullable = true)
  private Integer ctrlUser;
  @Column(name = "\"CTRL_AT\"", nullable = true)
  private Timestamp ctrlAt;
  @Column(name = "\"CTRL_DELTA\"", nullable = true)
  private Long ctrlDelta;
  @Column(name = "\"CTRL_COEFF\"", nullable = true)
  private Float ctrlCoeff;
  @Column(name = "\"IS_UPDATED\"", nullable = true)
  private Short isUpdated;
  @Column(name = "\"SEQ_NUMBER\"", nullable = false)
  private Integer seqNumber;
  @Column(name = "\"CARCASS_TYPE\"", nullable = true)
  private Integer carcassType;
  @Column(name = "\"DOC_ISSUE_AT\"", nullable = true)
  private Timestamp docIssueAt;
}