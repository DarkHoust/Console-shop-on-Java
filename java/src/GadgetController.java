import java.util.List;

public class GadgetController {
    private IGadgetRepo repo;

    public GadgetController(IGadgetRepo repo){
        this.repo = repo;
    }

    public String createGadget(String brand, String model, int amount){
        Gadgets gadgets = new Gadgets(brand,model,amount);

        boolean isCreated = repo.createGadget(gadgets);

        return (isCreated ? "Gadget has been added" : "Failed operation");
    }

    public String getGadgets(int id){
        Gadgets gadgets = repo.getGadget(id);

        return (gadgets == null? "This gadget is not exist" : gadgets.toString());
    }

    public String getAllGadgets(){
        List<Gadgets> gadgetsList=  repo.getAllGadgets();

        return gadgetsList.toString();
    }
}
