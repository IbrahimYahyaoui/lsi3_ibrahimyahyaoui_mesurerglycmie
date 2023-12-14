package com.example.lsi3_ibrahimyahyaoui_mesurerglycmie.controller;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.lsi3_ibrahimyahyaoui_mesurerglycmie.model.User;

public class LoginController {
private static User user ;
private static LoginController instance = null ;
    private static final String  SHERED_PREFS = "sahredPrefernce" ;
    private LoginController () {
    super();
}
public static  final LoginController getInstance(Context context)
{
    if(LoginController.instance == null) {
        instance = new LoginController();
    }
    recapUser(context);
    return LoginController.instance;
}

public  static  void  recapUser(Context context){
    //reccap saved data
    SharedPreferences sharedPreferences = context.getSharedPreferences(SHERED_PREFS,Context.MODE_PRIVATE);
    String userName = sharedPreferences.getString("username","");
    String password = sharedPreferences.getString("password","");

    user = new User(userName,password);
}
public void createUser (String name , String mdp , Context context) {
    //creation de l'utilisateur
    user = new User(name , mdp);
    //persistance des données de l'utilisateur
    SharedPreferences sharedPreferences = context.getSharedPreferences(SHERED_PREFS,Context.MODE_PRIVATE);
    SharedPreferences.Editor editor = sharedPreferences.edit();
    editor.putString("user",name);
    editor.putString("password",mdp);
    editor.apply();
}

    public String getName() {
        return user.getName();
    }

    public String getMdp() {
        return user.getMdp();
    }


}
