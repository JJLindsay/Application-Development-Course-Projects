package com.example.grizzlyMaps;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
//import android.view.View.OnClickListener;
import android.widget.Button;

public class MyActivity extends Activity
{
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        //initialize the buttons
        Button areaBtn = (Button) findViewById(R.id.area_button);
        Button campusBtn = (Button) findViewById(R.id.campus_button);
        Button aboutBtn = (Button) findViewById(R.id.about_button);

        //set the the onClickListener
        areaBtn.setOnClickListener(new AreaBtnListener());
        campusBtn.setOnClickListener(new CampusBtnListener());
        aboutBtn.setOnClickListener(new AboutBtnListener());
    }

    //inner class listener
    class AreaBtnListener implements View.OnClickListener
    {
        @Override
        public void onClick(View v)
        {
            //creates an intent to start a new activity
            startActivity(new Intent(MyActivity.this, AreaMap.class));
        }
    }

    //inner class listener
    class CampusBtnListener implements View.OnClickListener
    {
        @Override
        public void onClick(View v)
        {
            //creates an intent to start a new activity
            startActivity(new Intent(MyActivity.this, CampusMap.class));
        }
    }

    //inner class listener
    class AboutBtnListener implements View.OnClickListener
    {
        @Override
        public void onClick(View v)
        {
            //creates an intent to start a new activity
            startActivity(new Intent(MyActivity.this, CreatedBy.class));
        }
    }
}