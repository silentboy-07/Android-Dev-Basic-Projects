package com.example.simplecalculatorapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView resultTextView;
    private double firstNumber = 0;
    private double secondNumber = 0;
    private String operator = "";
    private boolean isOperatorPressed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultTextView = findViewById(R.id.resultTextView);

        // Set up button click listeners
        setNumberButtonClickListeners();
        setOperatorButtonClickListeners();
    }

    private void setNumberButtonClickListeners() {
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button button = (Button) view;
                String number = button.getText().toString();

                if (isOperatorPressed) {
                    resultTextView.setText(number);
                    isOperatorPressed = false;
                } else {
                    resultTextView.setText(resultTextView.getText().toString().equals("0") ? number : resultTextView.getText().toString() + number);
                }
            }
        };

        findViewById(R.id.btn0).setOnClickListener(listener);
        findViewById(R.id.btn1).setOnClickListener(listener);
        findViewById(R.id.btn2).setOnClickListener(listener);
        findViewById(R.id.btn3).setOnClickListener(listener);
        findViewById(R.id.btn4).setOnClickListener(listener);
        findViewById(R.id.btn5).setOnClickListener(listener);
        findViewById(R.id.btn6).setOnClickListener(listener);
        findViewById(R.id.btn7).setOnClickListener(listener);
        findViewById(R.id.btn8).setOnClickListener(listener);
        findViewById(R.id.btn9).setOnClickListener(listener);
    }

    private void setOperatorButtonClickListeners() {
        View.OnClickListener operatorListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button button = (Button) view;
                operator = button.getText().toString();
                firstNumber = Double.parseDouble(resultTextView.getText().toString());
                isOperatorPressed = true;
            }
        };

        findViewById(R.id.btnPlus).setOnClickListener(operatorListener);
        findViewById(R.id.btnMinus).setOnClickListener(operatorListener);
        findViewById(R.id.btnMultiply).setOnClickListener(operatorListener);
        findViewById(R.id.btnDivide).setOnClickListener(operatorListener);

        findViewById(R.id.btnEquals).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                secondNumber = Double.parseDouble(resultTextView.getText().toString());
                double result = 0;
                switch (operator) {
                    case "+":
                        result = firstNumber + secondNumber;
                        break;
                    case "-":
                        result = firstNumber - secondNumber;
                        break;
                    case "*":
                        result = firstNumber * secondNumber;
                        break;
                    case "/":
                        if (secondNumber != 0) {
                            result = firstNumber / secondNumber;
                        }
                        break;
                }
                resultTextView.setText(String.valueOf(result));
            }
        });
    }
}
