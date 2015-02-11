package com.example.gozinta;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * author: JJ Lindsay
 * version: 1.0
 * Course: ITEC 3150 Fall 2014
 * Written: 2/1/2015
 *
 * This class represents the bill calculation
 *
 * Purpose: Splits a bill by the number of the party members and the service quality
 */
public class MainActivity extends Activity
{

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        //standard code to open a layout
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        //calls the next activity once start is selected
        Button start = (Button)findViewById(R.id.startButton);
        start.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //creates an intent to start a new activity
                startActivity(new Intent(MainActivity.this, CalcActivity.class));
            }
        });
    }
}
