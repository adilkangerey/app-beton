package barakat.report;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.apache.commons.io.IOUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.*;

@Log4j2
@RestController
@RequestMapping("barakat/report")
public class ReportService {

    @Autowired
    Report report;
    /**
     * name  название в папке report/MyReports
     * [
     *     {
     *         "name":"start",
     *         "value":"2022-04-12T10:10",
     *         "javaType": "java.sql.Timestamp"
     *     }
     * ]
     * @param name
     * @param parameters
     * @param response
     * @return
     * @throws JasperException
     * @throws IOException
     */
    @CrossOrigin
    @PostMapping(value = "/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    private @ResponseBody
    String getReport(@PathVariable String name, @RequestBody List<ReportParameter> parameters, HttpServletResponse response) throws JasperException, IOException {
        Map<String, Object> parameters2 = new HashMap<>();
        for (ReportParameter parameter: parameters) {
            if(parameter.javaType == null || parameter.value == null || parameter.name == null){
                response.sendError(400, "parameter javaType|value|name is null");
            }else{
                switch (parameter.javaType){
                    case "java.sql.Timestamp":
                        parameters2.put(parameter.name,  Timestamp.valueOf(LocalDateTime.parse((String) parameter.value)));
                        break;
                    default: parameters2.put(parameter.name, parameter.value);break;
                }
            }
        }
        parameters2.put("projectPath", report.filesPath);
        response.setHeader("Content-disposition", "=attachment; filename=\""+name + ".pdf\"");
        response.setContentType(MediaType.APPLICATION_PDF_VALUE);
        return "\""+ report.generatePdfReport(name, parameters2) + "\"";
    }


    @CrossOrigin
    @GetMapping(value = "/download/{fileName}", produces = MediaType.APPLICATION_PDF_VALUE)
    private void downloadReport(@PathVariable String fileName, HttpServletResponse response) throws IOException {
        FileInputStream f = new FileInputStream(report.outputFolder+"/"+fileName);
        IOUtils.copy(f, response.getOutputStream());
    }
    @CrossOrigin
    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    private @ResponseBody List<ReportJasper> getAllReport(){
        List<ReportJasper> list = new ArrayList<>();
        list.add(new ReportJasper("barakatdetail", "Отчет Баракат Детально")
                .parameter("start", "java.sql.Timestamp", "Дата начала", "2022-04-02T10:10")
                .parameter("end", "java.sql.Timestamp", "Дата окончания", "2022-04-10T10:10")
//                .parameter("customfilter", "java.lang.String", "фильтр", "and customer.\"Name\" in ('') and wareh.\"Name\" in ('')")
        );
        return list;
    }
}
