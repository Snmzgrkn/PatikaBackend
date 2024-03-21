package Week_05.PatikaStore;

public class Notebook extends Product{
    private int RAM;
    private int storage;
    private double screenSize;

    public Notebook(int id, double unitPrice, double discountRate, int stock, String name, String brand, int RAM, int storage, double screenSize) {
        super(id, unitPrice, discountRate, stock, name, brand);
        this.RAM = RAM;
        this.storage = storage;
        this.screenSize = screenSize;
    }

    public int getRAM() {
        return RAM;
    }

    public void setRAM(int RAM) {
        this.RAM = RAM;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }
}
