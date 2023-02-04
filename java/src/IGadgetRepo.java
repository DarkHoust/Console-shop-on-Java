import java.util.List;

public interface IGadgetRepo {
    boolean createGadget(Gadgets gadget);
    Gadgets getGadjet(int id);
    List<Gadgets> getAllGadgets();
}
