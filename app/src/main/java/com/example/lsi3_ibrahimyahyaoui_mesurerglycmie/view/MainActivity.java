package com.example.lsi3_ibrahimyahyaoui_mesurerglycmie.view;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lsi3_ibrahimyahyaoui_mesurerglycmie.R;
import com.example.lsi3_ibrahimyahyaoui_mesurerglycmie.controller.Controller;

public class MainActivity extends AppCompatActivity {
    private Controller  controller = Controller.getInstance() ;

    private EditText vm;
    private SeekBar sbAge;
    private TextView res;
    private Button btn;
    private RadioGroup rbGrp;
    private TextView agePrv;
    private boolean Jeuner = true;

    private RadioButton oui;
    private RadioButton no;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        agePrv = findViewById(R.id.agePrv);
        vm = findViewById(R.id.vm);
        sbAge = findViewById(R.id.sbAGE);
        res = findViewById(R.id.res);
        rbGrp = findViewById(R.id.rbGrp);
        btn = findViewById(R.id.btnConsulter);
        oui = findViewById(R.id.oui);
        no = findViewById(R.id.cRB);

        if (oui.isChecked()) {

            Jeuner = true;
        } else if (no.isChecked()) {

            Jeuner = false;
        }
        sbAge.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // Update the TextView with the current progress value
                agePrv.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }


            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this, "Stop", Toast.LENGTH_SHORT).show();
            }
        });
        String vmText = vm.getText().toString().trim();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vm.clearFocus();
                int age = sbAge.getProgress();
                String vmText = vm.getText().toString().trim(); // Get the trimmed text

                // Check if age is greater than 0 and vmText is not empty
                if (age > 0 && !vmText.isEmpty()) {
                    float valeurM = Float.parseFloat(vmText);
                    controller.createPatient(age , valeurM , Jeuner);
                     res.setText(controller.getResult());

                } else {
                    Toast.makeText(MainActivity.this, "Niveau de glycémie or age are empty", Toast.LENGTH_SHORT).show();

                }
            }
        });

    }
}


