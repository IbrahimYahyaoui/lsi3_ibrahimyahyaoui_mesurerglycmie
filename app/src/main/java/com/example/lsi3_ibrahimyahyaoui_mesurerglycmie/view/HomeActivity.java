package com.example.lsi3_ibrahimyahyaoui_mesurerglycmie.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.lsi3_ibrahimyahyaoui_mesurerglycmie.R;
import com.example.lsi3_ibrahimyahyaoui_mesurerglycmie.controller.LoginController;

public class HomeActivity extends AppCompatActivity {
    private Button btnConsultation ;
    private EditText user=null;
    private EditText password=null;
    private static LoginController loginController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        init();

        user.setText(loginController.getName());
        password.setText(loginController.getMdp());

        btnConsultation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent  intent  = new Intent(HomeActivity.this , MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
    public void init(){
        loginController = LoginController.getInstance(HomeActivity.this);
        EditText user = (EditText) findViewById(R.id.etUserName);
        EditText password = (EditText) findViewById(R.id.etPassword);
        btnConsultation = (Button)findViewById(R.id.btnConsultation);
    }
}