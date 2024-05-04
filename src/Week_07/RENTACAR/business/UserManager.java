package Week_07.RENTACAR.business;

import Week_07.RENTACAR.dao.UserDao;
import Week_07.RENTACAR.entity.User;

public class UserManager {
    private final UserDao userDao;


    public UserManager() {
        this.userDao = new UserDao();
    }

    public User findByLogin(String username,String password){

        return this.userDao.findByLogin(username,password);
    }
}
