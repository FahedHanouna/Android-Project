package com.example.a1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

import java.sql.SQLOutput;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        String resultText = "";





        EditText nameEt = findViewById(R.id.nameEt);
        EditText idEt = findViewById(R.id.idEt);

        if (!nameEt.getText().toString().isEmpty()) {
            resultText += "Name : " + nameEt.getText().toString();
        }
        if (!idEt.getText().toString().isEmpty()) {
            resultText += "\nThe Id : : " + idEt.getText().toString();
        }




        Button submitBt = findViewById(R.id.submitBt);
        TextView info = findViewById(R.id.infotx);

        CheckBox marriedCb = findViewById(R.id.marriedCb);
        RadioGroup genderRd = findViewById(R.id.gendeRg);
        RadioButton maleRb = findViewById(R.id.maleRb);
        RadioButton FemaleRb = findViewById(R.id.FemaleRb);

        EditText JobTittle = findViewById(R.id.jobT);
        EditText WifeName = findViewById(R.id.wifenameiD);
        EditText WifeId = findViewById(R.id.wifeiD);
        CheckBox Havekids = findViewById(R.id.HaveKids);
        EditText KidNum = findViewById(R.id.kidnum);

        submitBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEt.getText().toString();
                String id = idEt.getText().toString();
                String status = "" ;

               boolean isMarried = marriedCb.isChecked();
               if(isMarried){
                   status = "Married";
               }else{
                   status = "Single";
               }


               int SelectedRbId = genderRd.getCheckedRadioButtonId();
               String gender;
               if (SelectedRbId == R.id.maleRb){
                   gender = "Male";

               } else if (SelectedRbId == R.id.FemaleRb) {
                   gender = "Female";

               }else {
                   gender = "Not Selected Yet";
               }
                String resultText = "Name: " + name + "\nThe ID : " + id + "\nStatus : " + status + "\nGender : " + gender;

                if (!JobTittle.getText().toString().isEmpty()) {
                    resultText += "\nJob Title: " + JobTittle.getText().toString();
                }

                if (!WifeName.getText().toString().isEmpty()) {
                    resultText += "\nWife Name: " + WifeName.getText().toString();
                }

                if (!WifeId.getText().toString().isEmpty()) {
                    resultText += "\nWife ID: " + WifeId.getText().toString();
                }

                if (!KidNum.getText().toString().isEmpty()) {
                    resultText += "\nKids  : " + KidNum.getText().toString();
                }

                info.setText(resultText);








            }
        });
        genderRd.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.maleRb) {
                    System.out.println("SelectedButtonID = "+checkedId);
                    JobTittle.setVisibility(View.VISIBLE);
                } else {
                    JobTittle.setVisibility(View.GONE);
                }
            }
        });
        marriedCb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    WifeName.setVisibility(View.VISIBLE);
                    WifeId.setVisibility(View.VISIBLE);
                    Havekids.setVisibility(View.VISIBLE);
                } else {
                    WifeName.setVisibility(View.GONE);
                    WifeId.setVisibility(View.GONE);
                    Havekids.setVisibility(View.GONE);
                }
            }
        });
        Havekids.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    KidNum.setVisibility(View.VISIBLE);
                } else {
                    KidNum.setVisibility(View.GONE);
                }
            }
        });

    }
}
