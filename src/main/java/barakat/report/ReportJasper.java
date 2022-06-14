package barakat.report;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ReportJasper {
    String jasperFileName;
    String description;
    List<ReportParameter> parameters;

    public ReportJasper(String jasperFileName, String description) {
        this.jasperFileName = jasperFileName;
        this.description = description;
        parameters = new ArrayList<>();
    }

    public ReportJasper parameter(String name, String type, String description, String example){
        ReportParameter par  = new ReportParameter();
        par.setName(name);
        par.setJavaType(type);
        par.setDescription(description);
        par.setExample(example);
        parameters.add(par);
        return this;
    }
}
