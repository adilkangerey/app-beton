package barakat.controller;

import barakat.app.model.Catalog;
import barakat.app.repository.BkcustomersAppRepository;
import barakat.app.repository.mirrorgen.BkwarehousesTcRepository;
import barakat.tctransport.model.gen.Bkcustomers;
import barakat.tctransport.model.gen.Bkwarehouses;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
* Generated by Spring Data Generator on 26/05/2022
*/
@Log4j2
@Getter
@CrossOrigin
@Configuration
@RestController
@RequestMapping("barakat/bkwarehouse")
public class BkwarehousesController {
    @Autowired
    BkwarehousesTcRepository repository;
    @Autowired
    BkcustomersController bkcustomersController;

    public Integer lastId(){
        List<Bkwarehouses> data = repository.findAll(PageRequest.of(0, 1, Sort.by("id").descending())).getContent();
        if(data.size() == 0){
            return 0;
        }else{
            return data.get(0).getId();
        }
    }

    @PostMapping(value = "/", produces = "application/json")
    Bkwarehouses create(@RequestBody Bkwarehouses bkwarehouses) {
        //todo подумать над HAL https://spring.io/guides/tutorials/rest/
        bkwarehouses.setId(lastId() + 1);
        bkwarehouses.setEnabled((short) 1);
        return repository.save(bkwarehouses);
    }

    @PostMapping(value = "/with-client", produces = "application/json")
    Bkwarehouses createWithClient(@RequestBody Bkwarehouses bkwarehouses, @Parameter String clientName) {
        //todo подумать над HAL https://spring.io/guides/tutorials/rest/
        Bkcustomers draft = new Bkcustomers();
        draft.setName(clientName);
        Bkcustomers bkcustomers = bkcustomersController.post(draft);
        bkwarehouses.setId(lastId() + 1);
        bkwarehouses.setEnabled((short) 1);
        bkwarehouses.setCustomerlink(bkcustomers.getId());
        return repository.save(bkwarehouses);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    Bkwarehouses findById(@PathVariable Integer id) throws NotFoundException {
        return repository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    @GetMapping(value = "/", produces = "application/json")
    List<Bkwarehouses> findAll(@Parameter Integer page, Integer size) throws NotFoundException {
        return repository.findAll(PageRequest.of(page, size)).getContent();
    }

    @GetMapping(value = "/by-client/{clientId}", produces = "application/json")
    List<Catalog> findByClient(@PathVariable Integer clientId) throws NotFoundException {
        return repository.findByCustomerlink(clientId);
    }




    @DeleteMapping(value = "/{id}", produces = "application/json")
    Integer disabledById(@PathVariable Integer id) throws NotFoundException {
        Bkwarehouses tcData = repository.findById(id).orElseThrow(() -> new NotFoundException(id));
        tcData.setEnabled((short) 0);
        repository.save(tcData);
        return tcData.getId();
    }
}