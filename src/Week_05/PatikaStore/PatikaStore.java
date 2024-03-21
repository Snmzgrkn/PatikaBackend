package Week_05.PatikaStore;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class PatikaStore {
    private List<CellPhone> cellPhones;

    private List<Notebook> notebooks;

    public PatikaStore() {

       cellPhones=new ArrayList<>();
       cellPhones.add(new CellPhone(1,20000,2,50,"Samsung Galaxy A51","Samsung","6",6.5,4000,6,"red"));


       notebooks = new ArrayList<>();
       notebooks.add(new Notebook(1,50000,10,5,"Monster Abra A5","Monster",16,500,15));
    }

    public void listProducts() {
        System.out.println("Cep Telefonları:");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.format("| %-5s | %-25s | %-15s | %-15s | %-15s | %-8s | %-15s | %-15s | %-12s | %-8s |%n",
                "ID", "Ürün Adı", "Marka", "Fiyat (TL)", "İndirim Oranı", "Stok", "Hafıza", "Ekran Boyutu (İnç)", "Pil Gücü (mAh)", "RAM (GB)");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
        for (CellPhone phone : cellPhones) {
            System.out.format("| %-5d | %-25s | %-15s | %-15.2f | %-15.2f | %-8d | %-15s | %-15.1f | %-12d | %-8d |%n",
                    phone.getId(), phone.getName(), phone.getBrand(), phone.getUnitPrice(), phone.getDiscountRate(),
                    phone.getStock(), phone.getMemory(), phone.getScreenSize(), phone.getBatteryPower(), phone.getRAM());
        }
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");

        System.out.println("\nNotebook'lar:");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.format("| %-5s | %-25s | %-15s | %-15s | %-15s | %-8s | %-12s | %-15s | %-15s |%n",
                "ID", "Ürün Adı", "Marka", "Fiyat (TL)", "İndirim Oranı", "Stok", "RAM (GB)", "Depolama (GB)", "Ekran Boyutu (İnç)");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
        for (Notebook notebook : notebooks) {
            System.out.format("| %-5d | %-25s | %-15s | %-15.2f | %-15.2f | %-8d | %-12d | %-15d | %-15.1f |%n",
                    notebook.getId(), notebook.getName(), notebook.getBrand(), notebook.getUnitPrice(),
                    notebook.getDiscountRate(), notebook.getStock(), notebook.getRAM(), notebook.getStorage(), notebook.getScreenSize());
        }
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
    }
}
