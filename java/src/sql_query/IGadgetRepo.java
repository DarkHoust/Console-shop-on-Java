package sql_query;

import java.util.List;
import entity.Gadgets;

public interface IGadgetRepo {
    boolean createGadget(Gadgets gadget);
    Gadgets getGadget(int id);
    List<Gadgets> getAllGadgets();
}
