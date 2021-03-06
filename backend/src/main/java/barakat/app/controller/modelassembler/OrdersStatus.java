package barakat.app.controller.modelassembler;

import java.util.Arrays;
import java.util.List;

public enum OrdersStatus {
    rejected,created,takedforwork,done,partdone;
    //created -> rejected
    //        -> takedforwork -> done
    //                        -> partdone
    public List<OrdersStatus> getPossibleChoises(){
        switch (this){
            case created:return Arrays.asList(rejected, takedforwork);
            case takedforwork:return Arrays.asList(done, partdone);
            case rejected:
            case done:
            case partdone:
                return Arrays.asList();
            default: return Arrays.asList(created);
        }
    }
}
