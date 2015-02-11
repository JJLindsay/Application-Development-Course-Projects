package com.example.gozinta;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;

/**
 * author: JJ Lindsay
 * version: 1.0
 * Course: ITEC 3150 Fall 2014
 * Written: 2/1/2015
 *
 * This class represents the main screen
 *
 * Purpose: To welcome the user and provide an access point to the next screen
 */
public class CalcActivity extends Activity
{
    private EditText partySize;
    private TextView results;
    private EditText bill;
    private Spinner service;

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator);

        results = (TextView)findViewById(R.id.result);
        service = (Spinner)findViewById(R.id.spinner);
        bill = (EditText)findViewById(R.id.billEditTxt);
        partySize = (EditText)findViewById(R.id.numOfParty);
        Button calculate = (Button)findViewById(R.id.calculateButton);
        calculate.setOnClickListener(new Calculation());
    }

    //inner class onClickListener
    class Calculation implements View.OnClickListener
    {
        @Override
        public void onClick(View v)
        {
            double tip;

            //IMPORTANT(!)(!) Don't forget to use .getSelected() to read a spinner
            if (service.getSelectedItem().toString().equals("Excellent"))
            {
                tip = 0.18;
            }
            else if (service.getSelectedItem().toString().equals("Average"))
            {
                tip = 0.15;
            }
            else
            {
                tip = 0.10;
            }
            double splitBill = ((tip * Double.parseDouble(bill.getText().toString())) + Double.parseDouble(bill.getText().toString())) / Integer.parseInt(partySize.getText().toString());

            //IMPORTANT(!)(!) Never us .toString immediately, first .getSelected() to read a spinner or .getText() for EditText
            //THEN use .toString()
            DecimalFormat currency = new DecimalFormat("$###,###.##");
            results.setText("Price Per Person is " + currency.format(splitBill));
        }
    }
}