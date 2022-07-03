package com.pritul.bmi_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edtWeight,edtHeightFt,edtHeightInch;
        Button calculateBMI;
        TextView txtResult;
        LinearLayout LLMain;

        edtWeight=findViewById(R.id.edtWeight);
        edtHeightFt=findViewById(R.id.edtHeightFt);
        edtHeightInch=findViewById(R.id.edtHeightInch);
        calculateBMI=findViewById(R.id.calculateBMI);
        txtResult=findViewById(R.id.txtResult);
        LLMain=findViewById(R.id.LLMain);

        calculateBMI.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                int wt=Integer.parseInt(edtWeight.getText().toString());
                int hf=Integer.parseInt(edtHeightFt.getText().toString());
                int in=Integer.parseInt(edtHeightInch.getText().toString());

                int totalIn=wt*12+in;
                double totalCm=totalIn*2.53;

                double totalM=totalCm/(100);
                double bmi=wt/(totalM*totalM);

                if (bmi>25){
                    txtResult.setText("you are overWeight");
                    LLMain.setBackgroundColor(getResources().getColor(R.color.color1));
                }
                else if (bmi>18)
                {
                    txtResult.setText("you are underWeight");
                    LLMain.setBackgroundColor(getResources().getColor(R.color.color2));
                }
                else{
                    txtResult.setText("you are healthy");
                    LLMain.setBackgroundColor(getResources().getColor(R.color.teal_700));
                }

            }
        });

    }
}