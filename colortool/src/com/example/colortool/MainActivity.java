package com.example.colortool;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity
{
    EditText redColor, greenColor, blueColor;
    Button showBtn;
    TextView display;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        redColor = (EditText) findViewById(R.id.editTextRed);
        greenColor = (EditText) findViewById(R.id.editTextGreen);
        blueColor = (EditText) findViewById(R.id.editTextBlue);
        showBtn = (Button) findViewById(R.id.buttonShow);
        display = (TextView) findViewById(R.id.textViewDisplay);

        showBtn.setOnClickListener(new displayColor());
    }

    class displayColor implements View.OnClickListener
    {
        public void onClick(View v)
        {
            int r = Integer.parseInt(redColor.getText().toString());
            int g = Integer.parseInt(greenColor.getText().toString());
            int b = Integer.parseInt(blueColor.getText().toString());

            display.setBackgroundColor(Color.rgb(r, g, b));
            String hex = String.format("#%02x%02x%02x", r, g, b);
            display.setText(hex);
        }
    }
}