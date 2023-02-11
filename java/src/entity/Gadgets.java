package entity;

public class Gadgets {
    private int id;
    private String brand;
    private String model;
    private int amount;

    public Gadgets(){

    }public Gadgets(int amount, String brand, String model) {
        setAmount(amount);
        setBrand(brand);
        setModel(model);
    }
    public Gadgets(int id, String brand, String model , int amount){
        setAmount(amount);
        setBrand(brand);
        setId(id);
        setModel(model);
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public String getBrand() {
        return brand;
    }

    public int getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    @Override
    public String toString() {
        return
                "id: " + id +
                ", brand: " + brand +
                ", model: '" + model +
                ", amount: " + amount;
    }
}
