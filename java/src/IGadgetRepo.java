import java.util.List;

public interface IGadgetRepo {
    boolean createGadget(Gadgets gadget);
    Gadgets getGadget(int id);
    List<Gadgets> getAllGadgets();
}
