package com.example.temperaturecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //declaring elements
    EditText editTemp;
    RadioButton radioC;
    RadioButton radioF;
    Button btnCalc;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //to connect elements in XML from their ID to java class
        editTemp = findViewById(R.id.editTemp);
        radioC = findViewById(R.id.radioC);
        radioF = findViewById(R.id.radioF);
        btnCalc = findViewById(R.id.btnCalc);
        result = findViewById(R.id.result);

    }


    public void calculateAnswer(View view){

        calculation cal = new calculation();
        String value = editTemp.getText().toString();

        //checking weather the value is empty
        if(TextUtils.isEmpty(value)){
            Toast.makeText(this, "Please Enter Value", Toast.LENGTH_SHORT).show();
            result.setText(null);
        }
        else {
            float temp = Float.parseFloat(value);

            //convert into fahrenhite
            if (radioC.isChecked()) {
                temp = cal.convertCelciusToFahrenheit(temp);
                result.setText(new Float(temp).toString() + " fahrenheit");
            }
                //convert into celcious
            else if (radioF.isChecked()) {
                temp = cal.convertFahrenheitToCelcius(temp);
                result.setText(new Float(temp).toString() + " celsius");
            }
            else {
                Toast.makeText(this, "Select a radio button", Toast.LENGTH_SHORT).show();
                result.setText(null);
            }
        }
    }

}