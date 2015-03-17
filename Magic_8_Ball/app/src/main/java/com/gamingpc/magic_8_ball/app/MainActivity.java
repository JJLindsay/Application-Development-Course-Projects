package com.gamingpc.magic_8_ball.app;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.hardware.SensorEvent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends Activity implements SensorEventListener
{
    private boolean facedown;
    private int count = 0;
    private MediaPlayer[] myset = new MediaPlayer[21];
//    int num = (int)(Math.random()*20);  //this never reaches 20 but its ok


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        if (savedInstanceState != null) {
            // Restore value of members from saved state

            facedown = savedInstanceState.getBoolean("fdwn");
        }

        setContentView(R.layout.activity_main);

        SensorManager sManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sManager.registerListener(this, sManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                SensorManager.SENSOR_DELAY_UI);


        for (int i = 0; i < myset.length; i++)
        {
            myset[i] = new MediaPlayer();
        }

        myset[0] = MediaPlayer.create(this, R.raw.outlook_not);
        myset[1] = MediaPlayer.create(this, R.raw.ask_again);
        myset[2] = MediaPlayer.create(this, R.raw.ask_later);
        myset[3] = MediaPlayer.create(this, R.raw.better_not_now);
        myset[4] = MediaPlayer.create(this, R.raw.cannot_predict);
        myset[5] = MediaPlayer.create(this, R.raw.certain);
        myset[6] = MediaPlayer.create(this, R.raw.decidely);
        myset[7] = MediaPlayer.create(this, R.raw.yes2);
        myset[8] = MediaPlayer.create(this, R.raw.yes);
        myset[9] = MediaPlayer.create(this, R.raw.sources_say);
        myset[10] = MediaPlayer.create(this, R.raw.reply_no);
        myset[11] = MediaPlayer.create(this, R.raw.reply_hazy);
        myset[12] = MediaPlayer.create(this, R.raw.rely_on_it);
        myset[13] = MediaPlayer.create(this, R.raw.point_to_yes);
        myset[14] = MediaPlayer.create(this, R.raw.dont_count);
        myset[15] = MediaPlayer.create(this, R.raw.doubt);
        myset[16] = MediaPlayer.create(this, R.raw.doubtful);
        myset[17] = MediaPlayer.create(this, R.raw.likely);
        myset[18] = MediaPlayer.create(this, R.raw.outlook);
        myset[19] = MediaPlayer.create(this, R.raw.definitely);

        myset[20] = MediaPlayer.create(this, R.raw.notice_tone);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Save the user's current game state
        savedInstanceState.putBoolean("fdwn", facedown);
//        savedInstanceState.putInt(mNum, num);


        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onAccuracyChanged(Sensor arg0, int arg1) {
        // TODO Auto-generated method stub

    }

    public void onSensorChanged(SensorEvent event)
    {
        float z = event.values[2];
        float x = event.values[0];
        float y = event.values[1];
//        int num = (int)(Math.random()*20);  //this never reaches 20 but its ok

        if (z > 9 && z < 10)
        {
            Log.i("Lindsay", "FACING UP");
            facedown = false;
            count = 0;
        }
        else if ((z > -10 && z < -9) ) { // this may be an improvement over
            // over what we did in class
            Log.i("Lindsay", "FACING DOWN");
            int num = (int)(Math.random()*20);  //this never reaches 20 but its ok
            count++;
            if (count == 10)
            {
                myset[20].start();
                facedown=true;
            }

            if (facedown)
            {
                if (x < -3 || y > 3)
                {
                    facedown = false;

                    myset[num].start();

                    Log.i("Lindsay", "The phone SHAKED!!" );
                }
            }
            Log.i("Lindsay",event.values[0] + " :: " + event.values[1] + " :: " + event.values[2] + " " );
        }
    }
}