package com.example.bmi;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


            EditText edtWeight, edtHeightft, edtHeightIn;
            Button btnCalculate;
            TextView txtResult;
            LinearLayout llMain;

            edtWeight = findViewById(R.id.edtWeight);
            edtHeightft = findViewById(R.id.edtHeightft);
            edtHeightIn = findViewById(R.id.edtHeightIn);
            btnCalculate = findViewById(R.id.btnCalculator);
            txtResult = findViewById(R.id.txtResult);
            llMain = findViewById(R.id.llMain);


            btnCalculate.setOnClickListener(new View.OnClickListener(){

                @SuppressLint("SetTextI18n")
                @Override
                public void onClick(View v) {
                    int wt = Integer.parseInt(edtWeight.getText().toString());
                    int ft = Integer.parseInt(edtHeightft.getText().toString());
                    int in = Integer.parseInt(edtHeightIn.getText().toString());

                    int totalIn = ft*12 + in;

                    double totalCm = totalIn*2.53;

                    double bmi = wt / ((totalCm / 100) * (totalCm / 100));

                    if (bmi>25){
                        txtResult.setText("You are overweight");
                        llMain.setBackgroundColor(getResources().getColor(R.color.colorOW));
                    }
                    else if (bmi<18){
                        txtResult.setText("You are under weight");
                        llMain.setBackgroundColor(getResources().getColor(R.color.colorUW));
                    }
                    else {
                        txtResult.setText("You are healthy");
                        llMain.setBackgroundColor(getResources().getColor(R.color.colorH));
                    }

                }
            });

    }
}