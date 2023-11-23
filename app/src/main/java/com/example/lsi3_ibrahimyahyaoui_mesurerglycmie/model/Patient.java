package com.example.lsi3_ibrahimyahyaoui_mesurerglycmie.model;

public class Patient {
    private int Age ;
    private boolean isFast ;

    private float NvGlycemie;

    private  String res ;


    public Patient(int age, boolean isFast, float nvGlycemie ) {
        Age = age;
        this.isFast = isFast;
        NvGlycemie = nvGlycemie;

    }

    public void setAge(int age) {
        Age = age;
    }

    public void setFast(boolean fast) {
        isFast = fast;
    }

    public void setNvGlycemie(float nvGlycemie) {
        NvGlycemie = nvGlycemie;
    }

    public void setRes(String res) {
        this.res = res;
    }

    public int getAge() {
        return Age;
    }

    public boolean isFast() {
        return isFast;
    }

    public float getNvGlycemie() {
        return NvGlycemie;
    }
//Update model-->controller
    public String getRes() {
        return res;
    }

    private void Calculer () {
            if (this.Age > 0 || this.NvGlycemie > 0) {
                if (this.Age >= 13 && (this.NvGlycemie >= 5.0 && this.NvGlycemie <= 7.2)) {
                    setRes("Niveau de glycémie est normale 1");
                } else if (this.Age >= 6 && (this.NvGlycemie >= 5.0 && this.NvGlycemie <= 10.0)) {
                    setRes("Niveau de glycémie est normale 2");
                } else if (this.NvGlycemie >= 5.5 && this.NvGlycemie <= 10.0) {
                    setRes("Niveau de glycémie est normale 3");
                } else {
                    setRes("Niveau de glycémie est trop bas ou niveau de glycémie est trop élevée 1");
                }
            } else {
                if (this.Age >= 13 && this.NvGlycemie < 10.5) {
                    setRes( "Niveau de glycémie est normale");
                } else {
                    setRes("Niveau de glycémie est trop bas ou niveau de glycémie est trop élevée 2");
                }
            }

        }

    }



