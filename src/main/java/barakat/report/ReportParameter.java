package barakat.report;

import lombok.Data;

@Data
public class ReportParameter {
    String name;
    String javaType;
    Object value;
    String description;
    String example;
}
