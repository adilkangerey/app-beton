package barakat.app.model;

import lombok.Data;

@Data
public class Catalog {
    String name;
    Integer id;

    public Catalog(String name, Integer id) {
        this.name = name;
        this.id = id;
    }
}
