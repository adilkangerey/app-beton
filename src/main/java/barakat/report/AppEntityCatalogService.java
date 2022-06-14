package barakat.report;


import barakat.app.repository.BkCatalogRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Log4j2
@RestController
@RequestMapping("barakat/catalog")
public class AppEntityCatalogService {

    @Autowired
    BkCatalogRepository bkCatalogRepository;

    @CrossOrigin
    @GetMapping(value = "/clients", produces = MediaType.APPLICATION_JSON_VALUE)
    private List<String> getClientsCatalog(@RequestParam String start, @RequestParam String end, HttpServletResponse response) throws IOException {
        if( start == null || end == null ){
            response.sendError(400, "parameter start or end is null");
        }else{
            return bkCatalogRepository.getClientsCatalog(
                    Timestamp.valueOf(LocalDateTime.parse((start))),
                    Timestamp.valueOf(LocalDateTime.parse((end)))
            );
        }

        return null;
    }

    @CrossOrigin
    @GetMapping(value = "/warehouses", produces = MediaType.APPLICATION_JSON_VALUE)
    private List<String> getWarehouseCatalog(@RequestParam String start, @RequestParam String end, HttpServletResponse response) throws IOException {
        if( start == null || end == null ){
            response.sendError(400, "parameter start or end is null");
        }else{
            return bkCatalogRepository.getWarehouseCatalog(
                    Timestamp.valueOf(LocalDateTime.parse((start))),
                    Timestamp.valueOf(LocalDateTime.parse((end)))
            );
        }

        return null;
    }
}
