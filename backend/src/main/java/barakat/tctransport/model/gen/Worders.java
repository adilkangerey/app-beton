package barakat.tctransport.model.gen;

import java.io.Serializable;
import java.sql.*;
import javax.persistence.*;

import barakat.app.entity.Order;
import lombok.Data;

/**
 * Список заявок на взвешивание ТС
 */
@Data
@Entity(name = "barakat.app.aggregator.entity.tctransport.model.gen.Worders")
@Table(name = "wOrders")
public class Worders implements Serializable {

  @Id
  @Column(name = "\"ID\"", nullable = false)
  private Integer id;
  @ManyToOne
  private Order appOrder;
  @Column(name = "\"TranspNum\"", nullable = true)
  private String transpnum;
  @Column(name = "\"Driver\"", nullable = true)
  private String driver;
  @Column(name = "\"Description\"", nullable = true)
  private String description;
  @Column(name = "\"InvoiceNum\"", nullable = true)
  private String invoicenum;
  @Column(name = "\"InvoiceSeria\"", nullable = true)
  private String invoiceseria;
  @Column(name = "\"RoadDoc\"", nullable = true)
  private String roaddoc;
  @Column(name = "\"ProductLink\"", nullable = true)
  private Integer productlink;
  @Column(name = "\"CustomerLink\"", nullable = true)
  private Integer customerlink;
  @Column(name = "\"VendorLink\"", nullable = true)
  private Integer vendorlink;
  @Column(name = "\"TransporterLink\"", nullable = true)
  private Integer transporterlink;
  @Column(name = "\"PayerLink\"", nullable = true)
  private Integer payerlink;
  @Column(name = "\"WarehouseLink\"", nullable = true)
  private Integer warehouselink;
  @Column(name = "\"WarehouseOutLink\"", nullable = true)
  private Integer warehouseoutlink;
  @Column(name = "\"CreateAt\"", nullable = false)
  private Timestamp createat;
  @Column(name = "\"JobStartAt\"", nullable = true)
  private Timestamp jobstartat;
  @Column(name = "\"JobFinishAt\"", nullable = true)
  private Timestamp jobfinishat;
  @Column(name = "\"Author\"", nullable = false)
  private Integer author;
  @Column(name = "\"Tare\"", nullable = true)
  private Integer tare;
  @Column(name = "\"RunCount\"", nullable = true)
  private Integer runcount;
  @Column(name = "\"TrailerNum\"", nullable = true)
  private String trailernum;
}