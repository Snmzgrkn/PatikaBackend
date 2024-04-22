package Week_07.RENTACAR.core;

import Week_07.RENTACAR.view.LoginView;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Helper {
    public static void setTheme(){
        for(UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()){
            if("Nimbus".equals(info.getName())){
                try {
                    UIManager.setLookAndFeel(info.getClassName());

                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }

    public static void showMessage(String str){
        optionPaneTR();
        String msg;
        String title = switch (str) {
            case "fill" -> {
                msg = "Lütfen tüm alanları doldurunuz!";
                yield "Hata";
            }
            case "done" -> {
                msg = "İşlem Başarılı";
                yield "Sonuç";
            }
            case "notfound" -> {
                msg = "Kayıt Bulunamadı!";
                yield "Bulunamadı";
            }
            case "error" -> {
                msg = "Hatalı İşlem yaptınız";
                yield "Hata";
            }
            default -> {
                msg = str;
                yield "Mesaj";
            }
        };

        JOptionPane.showMessageDialog(null,
                msg,
                title,
                JOptionPane.INFORMATION_MESSAGE);
    }

    public static boolean confirm(String str){
        optionPaneTR();
        String msg;
        if(str.equals("sure")){
            msg = "Bu işlemi yapmak istediğine emin misin?";
        }else {
            msg = str;
        }
        return JOptionPane.showConfirmDialog(null,msg,"Eminmisin ?",JOptionPane.YES_NO_OPTION) == 0;
    }
    public static boolean isFieldEmpty(JTextField field){
        return field.getText().trim().isEmpty();
    }

    public static boolean isFieldListEmpty(JTextField[] fieldList){
        for (JTextField field:fieldList){
            if(isFieldEmpty(field)) return true;

        }
        return false;
    }
    public static int getLocation(String type, Dimension size){
        return switch (type) {
            case "x" -> (Toolkit.getDefaultToolkit().getScreenSize().width - size.width) / 2;
            case "y" -> (Toolkit.getDefaultToolkit().getScreenSize().height - size.height) / 2;
            default -> 0;
        };
    }

    public static void optionPaneTR(){
        UIManager.put("OptionPane.okButtonText","Tamam");
        UIManager.put("OptionPane.yesButtonText","Evet");
        UIManager.put("OptionPane.noButtonText","Hayır");

    }


}
