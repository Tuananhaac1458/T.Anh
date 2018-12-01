package com.example.admin.du_an_1.Controller;

import android.content.Context;
import android.widget.Toast;

import com.example.admin.du_an_1.DAO.daoUsers;
import com.example.admin.du_an_1.Repository.Users;

import java.util.ArrayList;
import java.util.List;

public class LoginService {
    Context context;
    daoUsers myDaoUser;
    List<Users> usersList;
    Users users;
    public LoginService(Context context) {
        this.context = context;
        myDaoUser= daoUsers.getInstance(context);
    }


    public boolean Login(String username,String password){
        if(adminLogin(username,password) == true){
            return true;
        }
        else if (userLogin(username,password) == true){
            return true;
        }
        return false;
    }

    private boolean adminLogin(String username,String password){
        if((username.equals("admin")) &&( password.equals("admin"))){
            Toast.makeText(context, "Login as Admin", Toast.LENGTH_SHORT).show();
            return true;
        }
        return false;
    }

    private boolean userLogin(String username,String password){
        usersList = new ArrayList<>();
        usersList = myDaoUser.getAllItem();
        for (int i = 0; i<usersList.size();i++){
            users = usersList.get(i);
            if (users.getUserName().equals(username) && users.getPassword().equals(password)){
                Toast.makeText(context, "Login as" + username , Toast.LENGTH_SHORT).show();
                return true;
            }
        }
        return false;
    }
}
