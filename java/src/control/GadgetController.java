package control;

import control.InterfacesForGadgets.Controller;
import java.util.List;
import sql_query.Interfaces.IGadgetRepo;
import entity.Gadgets;

public class GadgetController implements Controller {
    private IGadgetRepo repo;

    public GadgetController(IGadgetRepo repo){
        this.repo = repo;
    }

    @Override
    public String createGadget(String brand, String model, int amount){
        Gadgets gadgets = new Gadgets(brand,model,amount);

        boolean isCreated = repo.createGadget(gadgets);

        return (isCreated ? "Gadget has been added" : "Failed operation");
    }

    @Override
    public String getGadget(int id){
        Gadgets gadgets = repo.getGadget(id);

        return (gadgets == null? "This gadget is not exist" : gadgets.toString());
    }

    public String getAllGadgets(){
        List<Gadgets> gadgetsList=  repo.getAllGadgets();

        return gadgetsList.toString();
    }
}
