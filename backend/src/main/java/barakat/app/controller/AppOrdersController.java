package barakat.app.controller;

import barakat.app.entity.AppOrders;
import barakat.app.repository.AppOrdersRepository;
import barakat.app.view.AppOrdersDetail;
import barakat.controller.NotFoundException;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

/**
 * Generated by Spring Data Generator on 26/05/2022
 */
@Log4j2
@Getter
@RestController
@RequestMapping("barakat/apporders")
@CrossOrigin
public class AppOrdersController {
    @Autowired
    AppOrdersRepository repository;



    public Integer lastId(){
        List<AppOrders> data = repository.findAll(PageRequest.of(0, 1, Sort.by("id").descending())).getContent();
        if(data.size() == 0){
            return 0;
        }else{
            return data.get(0).getId();
        }
    }

    @PostMapping(value = "/", produces = "application/json")
    AppOrders post(@RequestBody AppOrders appOrders) {
        //todo подумать над HAL https://spring.io/guides/tutorials/rest/
        appOrders.setId(lastId() + 1);

        appOrders.setCreateAt(LocalDateTime.now(ZoneId.of("UTC")));

//        appOrders.setEnabled((short) 1);
        return repository.save(appOrders);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    AppOrders findById(@PathVariable Integer id) throws NotFoundException {
        return repository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    //@GetMapping(value = "/", produces = "application/json")
    List<AppOrders> findAll(@Parameter Integer page, Integer size) throws NotFoundException {
        return repository.findAll(PageRequest.of(page, size)).getContent();
    }

    @GetMapping(value = "/detail", produces = "application/json")
    List<AppOrdersDetail> findAllView(@Parameter Integer p, @Parameter Integer c) throws NotFoundException {
        return repository.detailView(PageRequest.of(p, c)).getContent();
    }

    @GetMapping(value = "/detail/pages", produces = "application/json")
    int findAllViewPages(@Parameter Integer p, @Parameter Integer c) throws NotFoundException {
        return (int)repository.count()/c;
    }

    @DeleteMapping(value = "/{id}", produces = "application/json")
    Integer disabledById(@PathVariable Integer id) throws NotFoundException {
        AppOrders tcData = repository.findById(id).orElseThrow(() -> new NotFoundException(id));
        repository.save(tcData);
        return tcData.getId();
    }
}
