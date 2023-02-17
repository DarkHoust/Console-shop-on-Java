package control.interfaces;

import entity.Gadgets;

import java.util.List;

public interface ControllerGadget {
    String createGadget(int amount, String brand, String model);
    String getGadget(int id);
    List<Gadgets> getAllGadgets();
    void updateInfo(int id, int amount);


}
