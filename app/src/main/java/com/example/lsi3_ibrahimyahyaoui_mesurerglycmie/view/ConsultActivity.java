package com.example.lsi3_ibrahimyahyaoui_mesurerglycmie.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lsi3_ibrahimyahyaoui_mesurerglycmie.R;

public class ConsultActivity extends AppCompatActivity {
    private TextView res;
    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consult);


        res = (TextView) findViewById(R.id.tvReponse);
        btn = (Button)findViewById(R.id.btnReturn);
    //
        Intent i = getIntent();
        String myres = i.getStringExtra("response");
        res.setText(myres);


        btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent  = new Intent();
                        if(myres != null) {
                            setResult(RESULT_OK , intent);
                        }else {
                            setResult(RESULT_CANCELED , intent);
                            finish();
                        }

                    }
                }

        );

    }
}