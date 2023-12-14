package com.example.lsi3_ibrahimyahyaoui_mesurerglycmie.model;

public class User {
    public String name;
    public String mdp ;


    public User(String name, String mdp) {
        this.name = name;
        this.mdp = mdp;
    }

    public String getName() {
        return name;
    }

    public String getMdp() {
        return mdp;
    }


}
