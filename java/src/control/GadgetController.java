package control;

import control.interfaces.ControllerGadget;
import java.util.List;
import sql_query.interfaces.IGadgetRepo;
import entity.Gadgets;

public class GadgetController implements ControllerGadget {
    private IGadgetRepo repo;

    public GadgetController(IGadgetRepo repo){
        this.repo = repo;
    }

    @Override
    public String createGadget(int amount, String brand, String model){
        Gadgets gadgets = new Gadgets(amount, brand,model);

        boolean isCreated = repo.createGadget(gadgets);

        return (isCreated ? "Gadget has been added" : "Failed operation");
    }

    @Override
    public String getGadget(int id){
        Gadgets gadgets = repo.getGadget(id);

        return (gadgets == null? "This gadget is not exist" : gadgets.toString());
    }

    public List<Gadgets> getAllGadgets(){
        List<Gadgets> gadgetsList = repo.getAllGadgets();

        return gadgetsList;
    }
}
