package com.example.pamproject6;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pamproject6.database.Dbcontroller;
import com.google.android.material.textfield.TextInputEditText;

import java.util.HashMap;

public class Temanbaru extends AppCompatActivity {
    private TextInputEditText tNama, tTelpon;
    private Button simpanBtn;
    String nm,tlp;
    Dbcontroller controller = new Dbcontroller(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teman_baru);

        tNama = (TextInputEditText) findViewById(R.id.tietNama);
        tTelpon = (TextInputEditText) findViewById(R.id.tietTelpon);
        simpanBtn = (Button) findViewById(R.id.buttonSave);

        simpanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tNama.getText().toString().isEmpty() || tTelpon.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(), "Data Belum komplit !", Toast.LENGTH_SHORT).show();

                }
                else{
                    nm = tNama.getText().toString();
                    tlp = tTelpon.getText().toString();

                    HashMap<String,String> qvalues = new HashMap<>();
                    qvalues.put("nama", nm);
                    qvalues.put("telpon", tlp);

                    controller.insertData(qvalues);
                    callHome();
                }
            }
        });
    }

    public  void  callHome(){
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
        finish();
    }
}
