package control;

public interface Controller {
    String createGadget(String brand, String model, int amount);
    String getGadget(int id);
    public String getAllGadgets();

}
