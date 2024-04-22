package Week_07.RENTACAR;

import Week_07.RENTACAR.business.UserManager;
import Week_07.RENTACAR.core.Db;
import Week_07.RENTACAR.core.Helper;
import Week_07.RENTACAR.entity.User;
import Week_07.RENTACAR.view.AdminView;
import Week_07.RENTACAR.view.LoginView;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class App {
    public static void main(String[] args) {
        Helper.setTheme();

        UserManager userManager = new UserManager();
        //LoginView loginView = new LoginView();
        AdminView adminView = new AdminView(userManager.findByLogin("admin","1234"));

    }
}
