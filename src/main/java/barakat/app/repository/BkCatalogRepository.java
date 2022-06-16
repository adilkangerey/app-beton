package barakat.app.repository;

import barakat.tctransport.model.gen.Bkcustomers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

/**
* Generated by Spring Data Generator on 03/06/2022
*/
//
@Repository
public interface BkCatalogRepository  extends JpaRepository<Bkcustomers, Integer>, JpaSpecificationExecutor<Bkcustomers>{

    @Query("SELECT\n" +
//            "--        main.\"State\" ,\n" +
            "    customer.name\n" +
//            "    product.\"Name\" product,\n" +
//            "       main.\"W1At\" start_,\n" +
//            "       main.\"W2At\" end_,\n" +
//            "--        main.ID,\n" +
//            "       main.\"TRANSPNO_HASH\",\n" +
//            "    convert(REPLACE(main.\"ExtF01\", ',', '.'), decimal) obiem,\n" +
//            "    transpcustomer.\"Name\" transpcustomer,\n" +
//            "    main.\"Netto\" netto,\n" +
//            "    main.\"Brutto\" brutto,\n" +
//            "       round(main.\"Netto\"/(convert(REPLACE(main.\"ExtF01\", ',', '.'), float)), 2) kub,\n" +
//            "       main.\"Tare\" tare,\n" +
//            "       user_.\"Name\" operator,\n" +
//            "       wareh.\"Name\" warehouse\n" +
//            "--доставка груза\n" +
            "FROM barakat.app.aggregator.entity.tctransport.model.gen.Wcargo cargo\n" +
//            "        --клиент заказчик\n" +
            "         left join barakat.app.aggregator.entity.tctransport.model.gen.Bkcustomers customer ON\n" +
            "        cargo.customerlink = customer.id\n" +
//            "        --детали\n" +
            "         left join barakat.app.aggregator.entity.tctransport.model.gen.Wunits unit ON\n" +
            "        cargo.wunitslink = unit.id\n" +
//            "        --основные данные заявки\n" +
            "         left join barakat.app.aggregator.entity.tctransport.model.gen.Wmain main ON\n" +
            "        unit.wmainlink = main.id\n" +

//            "\n" +
            "where \n" +
            "main.w1at >  :start  \n" +
            "and  main.w1at < :end \n" +
            "and main.w2at is not null \n" +
            "\n" +
            "group by customer.name\n" +
//            "-- and customer.\"Name\" in ('')\n" +
//            "-- and main.ID = 82631\n" +
            "ORDER BY customer.name ASC")
    List<String> getClientsCatalog(Timestamp start, Timestamp end);


    @Query("SELECT\n" +
//            "--        main.\"State\" ,\n" +
//            "    customer.name\n" +
//            "    product.\"Name\" product,\n" +
//            "       main.\"W1At\" start_,\n" +
//            "       main.\"W2At\" end_,\n" +
//            "--        main.ID,\n" +
//            "       main.\"TRANSPNO_HASH\",\n" +
//            "    convert(REPLACE(main.\"ExtF01\", ',', '.'), decimal) obiem,\n" +
//            "    transpcustomer.\"Name\" transpcustomer,\n" +
//            "    main.\"Netto\" netto,\n" +
//            "    main.\"Brutto\" brutto,\n" +
//            "       round(main.\"Netto\"/(convert(REPLACE(main.\"ExtF01\", ',', '.'), float)), 2) kub,\n" +
//            "       main.\"Tare\" tare,\n" +
//            "       user_.\"Name\" operator,\n" +
            "       wareh.name\n" +
//            "--доставка груза\n" +
            "FROM barakat.app.aggregator.entity.tctransport.model.gen.Wcargo cargo\n" +
//            "        --детали\n" +
            "         left join barakat.app.aggregator.entity.tctransport.model.gen.Wunits unit ON\n" +
            "        cargo.wunitslink = unit.id\n" +
//            "        --основные данные заявки\n" +
            "         left join barakat.app.aggregator.entity.tctransport.model.gen.Wmain main ON\n" +
            "        unit.wmainlink = main.id\n" +
            "        left join barakat.app.aggregator.entity.tctransport.model.gen.Bkwarehouses wareh on wareh.id = cargo.warehouseoutlink\n" +
//            "\n" +
            "where \n" +
            "main.w1at >  :start  \n" +
            "and  main.w1at < :end \n" +
            "and main.w2at is not null \n" +
            "\n" +
            "group by wareh.name\n" +
//            "-- and customer.\"Name\" in ('')\n" +
//            "-- and main.ID = 82631\n" +
            "ORDER BY wareh.name ASC")
    List<String> getWarehouseCatalog(Timestamp start, Timestamp end);
}
