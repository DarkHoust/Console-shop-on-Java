package control.interfaces;

public interface ControllerGadget {
    String createGadget(int amount, String brand, String model);
    String getGadget(int id);
    public String getAllGadgets();

}
