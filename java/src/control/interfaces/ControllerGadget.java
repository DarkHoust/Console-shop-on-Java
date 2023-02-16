package control.interfaces;

import entity.Gadgets;

import java.util.List;

public interface ControllerGadget {
    String createGadget(int amount, String brand, String model);
    String getGadget(int id);
    public List<Gadgets> getAllGadgets();

}
