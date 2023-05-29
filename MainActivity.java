package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.text.DecimalFormat;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText angleEditText;
    private Button calculateButton;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        angleEditText = findViewById(R.id.angleEditText);
        calculateButton = findViewById(R.id.calculateButton);
        resultTextView = findViewById(R.id.resultTextView);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateCosine();
            }
        });
    }

    private void calculateCosine() {
        String angleStr = angleEditText.getText().toString();
        if (!angleStr.isEmpty()) {
            double angle = Double.parseDouble(angleStr);
            double radians = Math.toRadians(angle);
            double cosine = Math.cos(radians);
            // Округление до 3 знаков после запятой
            DecimalFormat decimalFormat = new DecimalFormat("#.######");
            String roundedCosine = decimalFormat.format(cosine);

            resultTextView.setText(roundedCosine);rf
        } else {
            resultTextView.setText("Введите угол");
        }
    }
}
