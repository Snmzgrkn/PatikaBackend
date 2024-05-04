package Week_07.RENTACAR.dao;

import Week_07.RENTACAR.core.Db;
import Week_07.RENTACAR.entity.User;

import java.sql.*;
import java.util.ArrayList;

public class UserDao {
    private final Connection connection;

    public UserDao( ) {
        this.connection = Db.getInstance();
    }

    public ArrayList<User> findAll(){
        ArrayList<User> userList = new ArrayList<>();
        String sql = "SELECT * FROM public.user";
        try {
            ResultSet res = this.connection.createStatement().executeQuery(sql);
            while (res.next()){
                userList.add(this.match(res));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return userList;
    }

    public User findByLogin(String username,String password){
        User obj = null;
        String query = "SELECT * FROM public.user WHERE user_name = ? AND user_password = ?";
        try {
            PreparedStatement pr = this.connection.prepareStatement(query);
            pr.setString(1,username);
            pr.setString(2,password);
            ResultSet res = pr.executeQuery();
            if(res.next()){
                obj = this.match(res);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return obj;

    }

    public User match(ResultSet res) throws SQLException {
        User obj = new User();
        obj.setId(res.getInt("user_id"));
        obj.setUsername(res.getString("user_name"));
        obj.setPassword(res.getString("user_password"));
        obj.setRole(res.getString("user_role"));
        return obj;
    }
}
