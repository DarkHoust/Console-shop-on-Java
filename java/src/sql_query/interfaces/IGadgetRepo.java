package sql_query.interfaces;

import java.util.List;
import entity.Gadgets;

public interface IGadgetRepo {
    boolean createGadget(Gadgets gadget);
    Gadgets getGadget(int id);
    List<Gadgets> getAllGadgets();
    String UpdateAmount(int id, int amount);
    boolean isAvailable(int id);
}
