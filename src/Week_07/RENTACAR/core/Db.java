package Week_07.RENTACAR.core;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Db {
    //Singleton Design Pattern
    private  static Db instance = null;
    private Connection connection;
    private final String DB_URL="jdbc:postgresql://localhost:5432/rentacar";
    private final String DB_USERNAME="postgres";
    private final String DB_PASS = "1";

    private Db(){
        try{
            Properties properties = new Properties();
            FileInputStream in = new FileInputStream("C:\\Users\\Gurkan\\IdeaProjects\\Patika\\src\\Week_07\\RENTACAR\\database.properties");
            properties.load(in);
            in.close();

            this.connection = DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASS);
        }catch (SQLException e){
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static Connection getInstance() {
        try {
            if(instance ==null || instance.getConnection().isClosed()){
                instance = new Db();
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

        return instance.getConnection();
    }
}
