package com.example.medicalCalculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.text.DecimalFormat;

public class MainActivity extends Activity
{
    double conversionRate = 2.2;
    EditText weightET;
    RadioButton lbToKiloRad;
    RadioButton kiloToLbRad;
    TextView resultTV;
    Button convertBtn;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        weightET = (EditText) findViewById(R.id.txtWeight);
        lbToKiloRad = (RadioButton) findViewById(R.id.radLbToKilo);
        kiloToLbRad = (RadioButton) findViewById(R.id.radKiloToLb);
        resultTV = (TextView) findViewById(R.id.txtResult);
        Button convert = (Button) findViewById(R.id.btnConvert);

        convert.setOnClickListener(new WeightConversion());
    }

    class WeightConversion implements View.OnClickListener
    {
        int wt = Integer.parseInt(weightET.getText().toString());
//        double lbKilo = Double.parseDouble(lbToKiloRad.getText().toString());
//        double kiloLb = Double.parseDouble(kiloToLbRad.getText().toString());
        double convertedWeight = 0.0;
        DecimalFormat tenth = new DecimalFormat("#.#");

        @Override
        public void onClick(View v)
        {
            if (lbToKiloRad.isChecked())
            {
                if (wt <= 500)
                {
                    convertedWeight = wt / conversionRate;
                    resultTV.setText(tenth.format(convertedWeight) + " Kilograms");
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Pounds must be less than 500", Toast.LENGTH_LONG).show();
                }
            }
            if (kiloToLbRad.isChecked())
            {
                if (wt <= 500)
                {
                    convertedWeight = wt / conversionRate;
                    resultTV.setText(tenth.format(convertedWeight) + " Kilograms");
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Pounds must be less than 500", Toast.LENGTH_LONG).show();
                }
            }

        }
    }
}