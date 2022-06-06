package barakat.app.report;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class ReportJasper {
    String jasperFileName;
    List<ReportParameter> parameters;

    public ReportJasper(String jasperFileName) {
        this.jasperFileName = jasperFileName;
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