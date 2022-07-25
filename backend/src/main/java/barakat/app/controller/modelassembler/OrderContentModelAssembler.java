package barakat.app.controller.modelassembler;

import barakat.app.controller.OrdersController;
import barakat.app.repository.OrdersRepository;
import barakat.app.repository.BkcustomersAppRepository;
import barakat.app.repository.BkproductsTcRepository;
import barakat.app.repository.mirrorgen.BkwarehousesTcRepository;
import barakat.tctransport.model.gen.Bkcustomers;
import barakat.tctransport.model.gen.Bkproducts;
import barakat.tctransport.model.gen.Bkwarehouses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import java.util.HashMap;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class OrderContentModelAssembler implements RepresentationModelAssembler<OrderContent, EntityModel<OrderContent>> {

    @Autowired
    OrdersRepository repositoryOrder;
//    @Autowired
//    BkcustomersAppRepository repositoryCustomer;
//    @Autowired
//    BkproductsTcRepository repositoryProduct;
//    @Autowired
//    BkwarehousesTcRepository repositoryWarehouse;

    @Override
    public EntityModel<OrderContent> toModel(OrderContent content) {

//        Bkcustomers tempCustomer = new Bkcustomers();
//        Bkproducts tempProduct = new Bkproducts();
//        Bkwarehouses tempWarehouse = new Bkwarehouses();
//        content._additional = new HashMap<>();
//        content._additional.put("customerName", content.content.getBkCustomer().getName());//repositoryCustomer.findById(tomerId()).orElse(tempCustomer).getName());
//        content._additional.put("productName", repositoryProduct.findById(content.content.getBkProductId()).orElse(tempProduct).getName());
//        content._additional.put("warehouseName", repositoryWarehouse.findById(content.content.getBkWarehouseId()).orElse(tempWarehouse).getName());
        EntityModel<OrderContent> entityModel = EntityModel.of(content,
                linkTo(methodOn(OrdersController.class).one(content.content.getId())).withSelfRel(),
                linkTo(methodOn(OrdersController.class).all(null, null, null, null, null)).withRel("orders"));

        if(content.content.getStatus() != null){
            switch (OrdersStatus.valueOf(content.content.getStatus())){
                case created:
                    entityModel.add(linkTo(methodOn(OrdersController.class).cancel(content.content.getId(), "")).withRel("status_cancel"));
                    entityModel.add(linkTo(methodOn(OrdersController.class).editcheck(content.content.getId())).withRel("edit_check"));
                    entityModel.add(linkTo(methodOn(OrdersController.class).edit(null)).withRel("edit"));
                case takedforwork:
                case rejected:
                case done:
                case partdone:
                    break;
                //default: ;
            }
        }
        return entityModel;
    }
}