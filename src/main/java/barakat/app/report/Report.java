package barakat.app.report;

import lombok.extern.log4j.Log4j2;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.fonts.SimpleFontExtensionsRegistryFactory;
import net.sf.jasperreports.engine.xml.JRFontFactory;
import net.sf.jasperreports.export.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.support.Repositories;

import javax.sql.DataSource;
import java.io.File;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Log4j2
@Configuration
public class Report {



    @Value("${report.path}")
    String path;

    @Value("${report.outputFolder}")
    String outputFolder;

    @Autowired
    DataSource appDataSource;

    public String demo2() throws JasperException {

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("start", Timestamp.valueOf(LocalDateTime.parse("2022-04-05T10:10")));
        parameters.put("end", new Timestamp(2022, 4, 18, 0, 0,0,0));
        parameters.put("projectPath", "report/MyReports/");
        generatePdfReport("report1", parameters);
        return "ddd";
    }

    public void generatePdfReport(String reportName, Map<String, Object> parameters) throws JasperException {
        try {
            JasperReport jasperReport = JasperCompileManager
                    .compileReport(path +"/" + reportName + ".jrxml");
            JasperPrint jasperPrint = JasperFillManager.fillReport(
                    jasperReport, parameters, appDataSource.getConnection());
            // Make sure the output directory exists.
            File outDir = new File(outputFolder);
            outDir.mkdirs();
            // PDF Exportor.

            JRPdfExporter exporter = new JRPdfExporter();
            ExporterInput exporterInput = new SimpleExporterInput(jasperPrint);
            // ExporterInput
            exporter.setExporterInput(exporterInput);
            // ExporterOutput
            OutputStreamExporterOutput exporterOutput = new SimpleOutputStreamExporterOutput(
                    outputFolder + "/" + reportName + UUID.randomUUID().toString() + ".pdf");
            // Output
            exporter.setExporterOutput(exporterOutput);
            SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();
            exporter.setConfiguration(configuration);
            exporter.exportReport();
        }catch (Exception e){
            throw new JasperException("Не могу найти отчет или проблемы с отчетом",e);
        }

//        System.out.println(wmainRepository.count());
//        bkcategoriesCustomRepository.findActive();
//        wmainRepository.findAll(PageRequest.of(0, 10)).getContent().stream().forEach(it->System.out.println(it.toString()));;
    }
}
