package Week_07.RENTACAR.view;

import Week_07.RENTACAR.business.BrandManager;
import Week_07.RENTACAR.business.CarManager;
import Week_07.RENTACAR.business.ModelManager;
import Week_07.RENTACAR.core.ComboItem;
import Week_07.RENTACAR.core.Helper;
import Week_07.RENTACAR.entity.Brand;
import Week_07.RENTACAR.entity.Car;
import Week_07.RENTACAR.entity.Model;
import Week_07.RENTACAR.entity.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;
import java.util.ArrayList;

public class AdminView extends Layout {
    private JPanel container;
    private JLabel lbl_welcome;
    private JPanel pnl_top;
    private JTabbedPane pnl_model;
    private JButton btn_logout;
    private JPanel pnl_brand;
    private JScrollPane scrl_brand;
    private JTable tbl_brand;
    private JScrollPane scrl_model;
    private JTable tbl_model;
    private JComboBox cmb_s_model_brand;
    private JComboBox cmb_s_model_type;
    private JComboBox cmb_s_model_fuel;
    private JComboBox cmb_s_model_gear;
    private JButton btn_search_model;
    private JButton btn_cancel_model;
    private JTable tbl_car;
    private JFormattedTextField fld_strt_date;
    private JFormattedTextField fld_fnsh_date;
    private JComboBox cmb_booking_gear;
    private JComboBox cmb_booking_fuel;
    private JComboBox cmb_booking_type;
    private JButton btn_booking_search;
    private JTable tbl_booking;
    private JButton btn_cncl_booking;
    private User user;
    private DefaultTableModel tmld_brand = new DefaultTableModel();
    private DefaultTableModel tmld_model = new DefaultTableModel();
    private DefaultTableModel tmld_car = new DefaultTableModel();
    private DefaultTableModel tmld_booking = new DefaultTableModel();

    private BrandManager brandManager;
    private ModelManager modelManager;
    private CarManager carManager;
    private JPopupMenu brand_Menu;
    private JPopupMenu model_Menu;
    private JPopupMenu car_Menu;
    private JPopupMenu booking_Menu;
    private Object[] col_model;
    private Object[] col_car;
    public AdminView(User user) {
        this.brandManager = new BrandManager();
        this.modelManager = new ModelManager();
        this.carManager=new CarManager();
        this.add(container);
        this.guiInitilaze(1000,500);
        this.user=user;

        if(this.user== null){
            dispose();
        }

        this.lbl_welcome.setText("Hoşgeldiniz :" + this.user.getUsername());

        //Brand Tab Menu
        loadBrandTable();
        loadBrandComponent();

        //Model Tab Menu
        loadModelTable(null);
        loadModelComponent();
        loadModelFilter();

        //Car Tab Menu
        loadCarTable();
        loadCarComponent();

        //Booking Tab Menu
        loadBookingTable(null);
        loadBookingComponent();
        loadBookingFilter();


    }

    private void loadBookingComponent(){
        tableRowSelect(this.tbl_booking);
        this.booking_Menu = new JPopupMenu();
        this.booking_Menu.add("Rezervasyon Yap").addActionListener(e -> {
            int selectCarId = this.getTableSelectedRow(this.tbl_booking,0);
            BookingView bookingView = new BookingView(
                    this.carManager.getById(selectCarId),
                    this.fld_strt_date.getText(),
                    this.fld_fnsh_date.getText()
            );
            bookingView.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadBookingTable(null);
                    loadBookingFilter();
                }
            });
        });
        this.tbl_booking.setComponentPopupMenu(booking_Menu);

        btn_booking_search.addActionListener(e -> {
            ArrayList<Car> carList = this.carManager.searchForBooking(
                    fld_strt_date.getText(),
                    fld_fnsh_date.getText(),
                    (Model.Type) cmb_booking_type.getSelectedItem(),
                    (Model.Gear) cmb_booking_gear.getSelectedItem(),
                    (Model.Fuel) cmb_booking_fuel.getSelectedItem()
            );

            ArrayList<Object[]> carBookingRow = this.carManager.getForTable(this.col_car.length,carList);

            loadBookingTable(carBookingRow);
        });
        btn_cncl_booking.addActionListener(e -> {
            loadBookingFilter();
        });
    }

    private void loadBookingTable(ArrayList<Object[]> bookList){
        Object[] col_booking_list = {"ID","Marka","Model","Plaka","Renk","KM","Yıl","Tip","Yakıt Türü","Vites"};
        createTable(this.tmld_booking,this.tbl_booking,col_booking_list,bookList);
    }

    public void loadBookingFilter(){
        this.cmb_booking_type.setModel(new DefaultComboBoxModel<>(Model.Type.values()));
        this.cmb_booking_type.setSelectedItem(null);
        this.cmb_booking_gear.setModel(new DefaultComboBoxModel<>(Model.Gear.values()));
        this.cmb_booking_gear.setSelectedItem(null);
        this.cmb_booking_fuel.setModel(new DefaultComboBoxModel<>(Model.Fuel.values()));
        this.cmb_booking_fuel.setSelectedItem(null);
    }
    private void loadModelComponent() {
        tableRowSelect(this.tbl_model);

        this.model_Menu = new JPopupMenu();
        this.model_Menu.add("Yeni").addActionListener(e -> {
            ModelView modelView = new ModelView(new Model());
            modelView.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadModelTable(null);
                    loadBrandTable();
                }
            });
        });
        this.model_Menu.add("Güncelle").addActionListener(e->{
            int selectModelId = this.getTableSelectedRow(tbl_model,0);
            ModelView modelView = new ModelView(this.modelManager.getById(selectModelId));
            modelView.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadModelTable(null);
                    loadBrandTable();
                }
            });

        });
        this.model_Menu.add("Sil").addActionListener(e -> {
            if (Helper.confirm("sure")){
                int selectModelId = this.getTableSelectedRow(tbl_model,0);
                if(this.modelManager.delete(selectModelId)){
                    Helper.showMessage("done");
                    loadBrandTable();
                    loadModelTable(null);
                }else{
                    Helper.showMessage("error");
                }
            }
        });
        this.tbl_model.setComponentPopupMenu(model_Menu);

        this.btn_search_model.addActionListener(e -> {
            ComboItem selectedBrand =(ComboItem) this.cmb_s_model_brand.getSelectedItem();
            int brandId =0;
            if(selectedBrand != null){
                brandId = selectedBrand.getKey();
            }
            ArrayList<Model> modelListBySearch = this.modelManager.searchForTable(
                   brandId,
                    (Model.Fuel) cmb_s_model_fuel.getSelectedItem(),
                    (Model.Gear) cmb_s_model_gear.getSelectedItem(),
                    (Model.Type) cmb_s_model_type.getSelectedItem()
            );
            ArrayList<Object[]> modelRowListBySearch = this.modelManager.getForTable(this.col_model .length,modelListBySearch);
            loadModelTable(modelRowListBySearch);
        });

        this.btn_cancel_model.addActionListener(e -> {
            this.cmb_s_model_type.setSelectedItem(null);
            this.cmb_s_model_gear.setSelectedItem(null);
            this.cmb_s_model_fuel.setSelectedItem(null);
            this.cmb_s_model_brand.setSelectedItem(null);
            loadModelTable(null);
        });
    }
    public void loadCarTable(){
        col_car = new Object[]{"ID", "Marka", "Model", "Plaka", "Renk", "KM", "Yıl", "Tip", "Yakıt Türü", "Vites"};
        ArrayList<Object[]> carList = this.carManager.getForTable(col_car.length,this.carManager.findAll());
        createTable(this.tmld_car,this.tbl_car,col_car,carList);
    }
    private void loadCarComponent(){
        tableRowSelect(this.tbl_car);
        this.car_Menu = new JPopupMenu();
        this.car_Menu.add("Yeni").addActionListener(e -> {
            CarView carView = new CarView(new Car());
            carView.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadCarTable();
                }
            });
        });
        this.car_Menu.add("Güncelle").addActionListener(e->{
            int selectModelId = this.getTableSelectedRow(tbl_car,0);
            CarView carView = new CarView(this.carManager.getById(selectModelId));
            carView.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                loadCarTable();
                }
            });
        });
        this.car_Menu.add("Sil").addActionListener(e -> {
            if (Helper.confirm("sure")){
                int selectCarId = this.getTableSelectedRow(tbl_car,0);
                if(this.carManager.delete(selectCarId)){
                    Helper.showMessage("done");
                    loadCarTable();

                }else{
                    Helper.showMessage("error");
                }
            }
        });
        this.tbl_car.setComponentPopupMenu(car_Menu);


    }

    private void loadBrandComponent() {
        tableRowSelect(this.tbl_brand);
        this.brand_Menu = new JPopupMenu();
        this.brand_Menu.add("Yeni").addActionListener(e -> {
            BrandView brandView = new BrandView(null);
            brandView.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadBrandTable();
                    loadModelTable(null);
                    loadModelFilter();
                }
            });
        });
        this.brand_Menu.add("Güncelle").addActionListener(e->{
            int selectBrandId = this.getTableSelectedRow(tbl_brand,0);
            BrandView brandView = new BrandView(this.brandManager.getById(selectBrandId));
            brandView.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadBrandTable();
                    loadModelTable(null);
                    loadModelFilter();
                    loadCarTable();

                }
            });
        });
        this.brand_Menu.add("Sil").addActionListener(e -> {
            if (Helper.confirm("sure")){
                int selectBrandId = this.getTableSelectedRow(tbl_brand,0);
                if(this.brandManager.delete(selectBrandId)){
                    Helper.showMessage("done");
                    loadBrandTable();
                    loadModelTable(null);
                    loadModelFilter();
                    loadCarTable();

                }else{
                    Helper.showMessage("error");
                }
            }
        });
        this.tbl_brand.setComponentPopupMenu(brand_Menu);



    }

    public void loadBrandTable(){
        Object[] col_brand = {"Marka ID","Marka Adı"};
        ArrayList<Object[]> brandList = this.brandManager.getForTable(col_brand.length);
        createTable(this.tmld_brand,this.tbl_brand,col_brand,brandList);
    }
    public void loadModelTable(ArrayList<Object[]> modelList ){
        this.col_model = new Object[]{"Model ID", "Marka", "Model Adı", "Tipi", "Yıl", "Yakıt Türü", "Vites"};
        if (modelList == null){
            modelList = this.modelManager.getForTable(col_model.length,this.modelManager.findAll());

        }
        createTable(this.tmld_model,this.tbl_model,col_model,modelList);
    }

    public void loadModelFilter(){
        this.cmb_s_model_type.setModel(new DefaultComboBoxModel<>(Model.Type.values()));
        this.cmb_s_model_type.setSelectedItem(null);
        this.cmb_s_model_gear.setModel(new DefaultComboBoxModel<>(Model.Gear.values()));
        this.cmb_s_model_gear.setSelectedItem(null);
        this.cmb_s_model_fuel.setModel(new DefaultComboBoxModel<>(Model.Fuel.values()));
        this.cmb_s_model_fuel.setSelectedItem(null);
       loadModelFilterBrand();
    }

    public void loadModelFilterBrand(){
        this.cmb_s_model_brand.removeAllItems();
        for(Brand obj : brandManager.findAll()){
            this.cmb_s_model_brand.addItem(new ComboItem(obj.getId(),obj.getName()));
        }
        this.cmb_s_model_brand.setSelectedItem(null);
    }

    private void createUIComponents(){
        try {
            fld_strt_date = new JFormattedTextField(new MaskFormatter("##/##/####"));
            fld_fnsh_date = new JFormattedTextField(new MaskFormatter("##/##/####"));
            fld_strt_date.setText("10/10/2023");
            fld_fnsh_date.setText("16/10/2023");

        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
