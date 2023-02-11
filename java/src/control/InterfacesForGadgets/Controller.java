package control.InterfacesForGadgets;

public interface Controller {
    String createGadget(int amount, String brand, String model);
    String getGadget(int id);
    public String getAllGadgets();

}
