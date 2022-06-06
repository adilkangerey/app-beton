package barakat.app.report;

import com.google.gson.Gson;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
    @PostMapping(value = "/{name}", produces = MediaType.APPLICATION_PDF_VALUE)
    private @ResponseBody byte[] getReport(@PathVariable String name, @RequestBody List<ReportParameter> parameters, HttpServletResponse response) throws JasperException, IOException {
        Map<String, Object> parameters2 = new HashMap<>();
        for (ReportParameter parameter: parameters) {
            if(parameter.javaType == null || parameter.value == null || parameter.name == null){
                response.sendError(400, "parameter javaType|value|name is null");
                return null;
            }else{
                switch (parameter.javaType){
                    case "java.sql.Timestamp": parameters2.put(parameter.name, Timestamp.valueOf(LocalDateTime.parse((String) parameter.value)));break;
                    default: parameters2.put(parameter.name, parameter.value);break;
                }
            }
        }
        parameters2.put("projectPath", report.filesPath);
        response.setHeader("Content-disposition", "=attachment; filename="+name + ".pdf");
        FileInputStream f = new FileInputStream(report.generatePdfReport(name, parameters2));
        return IOUtils.toByteArray(f);
    }

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    private @ResponseBody String getAllReport(){
        List<Object> list = new ArrayList<>();
        list.add(new ReportJasper("report1").parameter("start", "java.sql.Timestamp", "Дата и время", "2022-04-02T10:10"));
//        List<Map<String, Object>> list2 = new ArrayList();
//        for(ReportJasper jp : list){
//            list2.add(new HashMap<String, Object>().)
//        }
//        list
        return new Gson().toJson(list);
//        return list;
    }
}
