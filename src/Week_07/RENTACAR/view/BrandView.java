package Week_07.RENTACAR.view;

import Week_07.RENTACAR.business.BrandManager;
import Week_07.RENTACAR.core.Helper;
import Week_07.RENTACAR.entity.Brand;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BrandView extends Layout {

    private JPanel container;
    private JLabel lbl_brand;
    private JLabel lbl_brandname;
    private JTextField fld_brandname;
    private JButton btn_brandsave;
    private Brand brand;
    private BrandManager brandManager;
    public BrandView(Brand brand ) {
        this.brandManager = new BrandManager();
        this.add(container);
        this.guiInitilaze(300,200);
        this.brand = brand;

        if (brand !=null){
            this.fld_brandname.setText(brand.getName());
        }
        btn_brandsave.addActionListener(e -> {
            if(Helper.isFieldEmpty(this.fld_brandname)){
                Helper.showMessage("fill");

            }else {
                boolean result =true;
                if(this.brand==null){
                    Brand obj =new Brand(fld_brandname.getText());
                    result = this.brandManager.save(obj);
                }else {
                    this.brand.setName(fld_brandname.getText());
                    result = this.brandManager.update(this.brand);
                }
                if(result){
                    Helper.showMessage("done");
                    dispose();
                }else {
                    Helper.showMessage("error");
                }
            }
        });
    }
}
