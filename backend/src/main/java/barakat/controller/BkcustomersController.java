package barakat.controller;

import barakat.app.model.Catalog;
import barakat.app.repository.BkcustomersAppRepository;
import barakat.tctransport.model.gen.Bkcustomers;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Generated by Spring Data Generator on 26/05/2022
 */
@Log4j2
@Getter
@RestController
@RequestMapping("barakat/bkcustomers")
@CrossOrigin
public class BkcustomersController implements TcTransportCopySchedule {
    @Autowired
    BkcustomersAppRepository repository;




    //@Scheduled(fixedDelay = 1000*60*5)
//    public void job(){
//        tcRepository.saveAll(repository.findAll());
//    }

    public Integer lastId(){
        List<Bkcustomers> data = repository.findAll(PageRequest.of(0, 1, Sort.by("id").descending())).getContent();
        if(data.size() == 0){
            return 0;
        }else{
            return data.get(0).getId();
        }
    }

    @Override
    public Logger getLogger() { return log; }

    @PostMapping(value = "/", produces = "application/json")
    Bkcustomers post(@RequestBody Bkcustomers bkcustomers) {
        //todo подумать над HAL https://spring.io/guides/tutorials/rest/
        bkcustomers.setId(lastId() + 1);
        bkcustomers.setEnabled((short) 1);
        bkcustomers.setEgrul("");
        bkcustomers.setInn("");
        bkcustomers.setKpp("");
        bkcustomers.setNameHash("");
        bkcustomers.setOgrn("");
        return repository.save(bkcustomers);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    Bkcustomers findById(@PathVariable Integer id) throws NotFoundException {
        return repository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    @GetMapping(value = "/", produces = "application/json")
    List<Bkcustomers> findAll(@Parameter Integer page, Integer size) throws NotFoundException {
        return repository.findAll(PageRequest.of(page, size)).getContent();
    }

    @GetMapping(value = "/catalog", produces = "application/json")
    List<Catalog> findAllCatalog(@Parameter String q) throws NotFoundException {
        return repository.findAllByName(q.toLowerCase());
    }


    @DeleteMapping(value = "/{id}", produces = "application/json")
    Integer disabledById(@PathVariable Integer id) throws NotFoundException {
        Bkcustomers tcData = repository.findById(id).orElseThrow(() -> new NotFoundException(id));
        tcData.setEnabled((short) 0);
        repository.save(tcData);
        return tcData.getId();
    }



}
