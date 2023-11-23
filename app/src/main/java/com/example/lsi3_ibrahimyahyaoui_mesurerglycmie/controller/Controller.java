package com.example.lsi3_ibrahimyahyaoui_mesurerglycmie.controller;

import com.example.lsi3_ibrahimyahyaoui_mesurerglycmie.model.Patient;

public class Controller {
    private static Controller instance = null ;
    private static Patient patient ;
    private Controller() {
        super();
    }

    public static Controller getInstance () {
        if (instance == null) {
            return new Controller();
        } else {
            return  instance ;
        }
    }

    public void createPatient (int age , float valeur , boolean isFasting ){
        patient = new Patient(age  , isFasting , valeur );
    }

    // update controller --> View
    public String getResult(){
            return patient.getRes();
    }



}
