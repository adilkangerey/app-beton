package barakat.app.controller.modelassembler;

import barakat.app.entity.Order;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Map;

@Data
public class OrderContent {
    Order content;
    Map<String, Object> _additional;

    public OrderContent(Order content) {
        this.content = content;
    }
}
