package barakat.app.entity;

import barakat.tctransport.model.gen.Wmain;
import barakat.tctransport.model.gen.Worders;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;


@Data
@Entity
@Table(name = "\"appOrders\"")
public class Order implements Serializable {

  @Id
  @Column(nullable = false)
  private Integer id;
//
//  @Column(name = "\"TranspNum\"", nullable = true)
//  private String transpnum;
//  @Column(name = "\"Driver\"", nullable = true)
//  private String driver;
//  @Column(name = "\"Description\"", nullable = true)
//  private String description;
//  @Column(name = "\"InvoiceNum\"", nullable = true)
//  private String invoicenum;
//  @Column(name = "\"InvoiceSeria\"", nullable = true)
//  private String invoiceseria;
//  @Column(name = "\"RoadDoc\"", nullable = true)
//  private String roaddoc;
//    @Column
//    private Integer productId;
    /*ТСТранспорт*/
    @Column
    private Integer bkProductId;
    /*ТСТранспорт*/
    @Column
    private Integer bkCustomerId;
    /*ТСТранспорт*/
    @Column
    private Integer bkWarehouseId;
//  @Column(name = "\"VendorLink\"", nullable = true)
//  private Integer vendorlink;
//  @Column(name = "\"TransporterLink\"", nullable = true)
//  private Integer transporterlink;
//  @Column(name = "\"PayerLink\"", nullable = true)
//  private Integer payerlink;
    /*ТСТранспорт*/
    @Column
    private Integer bkWarehouseOutId;
    @Column
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss'Z'")
    private LocalDateTime createAt;
//  @Column(name = "\"JobStartAt\"", nullable = true)
//  private Timestamp jobstartat;
//  @Column(name = "\"JobFinishAt\"", nullable = true)
//  private Timestamp jobfinishat;
    @Column
    private String createdUser;
    /*Кубический метр необходимый*/
    @Column
    private Float cubicMeter;
    //тип конструкции
    @Column
    private String construction;

    /*Осадок конуса*/
    @Column
    private Float coneSediment;


//    @OneToMany(mappedBy = "appOrder")
//    private List<Wmain> wMains;
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss'Z'")
    private LocalDateTime startTime;
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss'Z'")
    private LocalDateTime endTime;
    private Integer intervalMinutes;
    private String intervalComment;
    /*AppOrderStatus*/
    private String status;
//  @Column(name = "\"Author\"", nullable = false)
//  private Integer author;
//  @Column(name = "\"Tare\"", nullable = true)
//  private Integer tare;
//  @Column(name = "\"RunCount\"", nullable = true)
//  private Integer runcount;
//  @Column(name = "\"TrailerNum\"", nullable = true)
//  private String trailernum;


  Worders gettctransport(){
    Worders worders = new Worders();
    worders.setProductlink(bkProductId);
    worders.setCustomerlink(bkCustomerId);
    worders.setWarehouselink(bkWarehouseId);
    worders.setWarehouseoutlink(bkWarehouseOutId);
    worders.setCreateat(Timestamp.valueOf(createAt));

    //  @Column(name = "\"TranspNum\"", nullable = true)
//  private String transpnum;
//  @Column(name = "\"Driver\"", nullable = true)
//  private String driver;
//  @Column(name = "\"Description\"", nullable = true)
//  private String description;
//  @Column(name = "\"InvoiceNum\"", nullable = true)
//  private String invoicenum;
//  @Column(name = "\"InvoiceSeria\"", nullable = true)
//  private String invoiceseria;
//  @Column(name = "\"RoadDoc\"", nullable = true)
//  private String roaddoc;

//  @Column(name = "\"CustomerLink\"", nullable = true)
//  private Integer customerlink;
//  @Column(name = "\"VendorLink\"", nullable = true)
//  private Integer vendorlink;
//  @Column(name = "\"TransporterLink\"", nullable = true)
//  private Integer transporterlink;
//  @Column(name = "\"PayerLink\"", nullable = true)
//  private Integer payerlink;
//  @Column(name = "\"Tare\"", nullable = true)
//  private Integer tare;
//  @Column(name = "\"RunCount\"", nullable = true)
//  private Integer runcount;
//  @Column(name = "\"TrailerNum\"", nullable = true)
//  private String trailernum;
    return worders;
  }
}