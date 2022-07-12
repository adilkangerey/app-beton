package barakat.app.controller.modelassembler;

import java.util.Arrays;
import java.util.List;

public enum OrdersStatus {
    cancel,created,takedforwork,done,partdone;
    //created -> rejected
    //        -> takedforwork -> done
    //                        -> partdone
    public List<OrdersStatus> getPossibleChoises(){
        switch (this){
            case created:return Arrays.asList(cancel, takedforwork);
            case takedforwork:return Arrays.asList(done, partdone);
            case cancel:
            case done:
            case partdone:
                return Arrays.asList();
            default: return Arrays.asList(created);
        }
    }
}
