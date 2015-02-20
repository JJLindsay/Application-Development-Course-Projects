package com.example.currencyconverter;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

import java.text.DecimalFormat;

/**
* Created by JON-JULIUS on 2/17/2015.
*/
public class Main extends Activity {

    Button btnConverter;
    EditText edtTextMoney;
    Spinner spinnerTo;
    Spinner spinnerFrom;

    String endpoint = "http://rate-exchange.herokuapp.com";
    RateExchangeInterface service;
    TextView display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        btnConverter = (Button) findViewById(R.id.btnConvert);
        edtTextMoney = (EditText)findViewById(R.id.editTxtMoney);
        spinnerTo = (Spinner) findViewById(R.id.spinnerTo);
        spinnerFrom = (Spinner)findViewById(R.id.spinnerFrom);
        display = (TextView) findViewById(R.id.txtViewResult);

        btnConverter.setOnClickListener(new CurrencyConversion());

        RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(endpoint).build();
        service = restAdapter.create(RateExchangeInterface.class);
    }

    class CurrencyConversion implements View.OnClickListener
    {
        @Override
        public void onClick(View v)
        {
            MyTask task = new MyTask();
            task.execute(spinnerFrom.getSelectedItem().toString(),spinnerTo.getSelectedItem().toString());
        }
    }

    protected void updateDisplay(String result)
    {
        DecimalFormat tenth = new DecimalFormat("#.##");
        display.setText("The rate is: " + result +
                "\nYour currency is valued at: " + tenth.format(Double.parseDouble(edtTextMoney.getText().toString())
                * Double.parseDouble(result)) + " " + spinnerFrom.getSelectedItem().toString());
    }

    //subclass of AsyncTask(x,y, result)
    private class MyTask extends AsyncTask<String, String, String>
    {
        /**only ABSTRACT METHOD that must be defined
         * pass in any number of parameters in any order as long as they are String
         * 3rd parameter type of AsynTask above is what is the return type
         * for do in background
         * @param params objects to be passed to the background activity
         * @return null
         */
        @Override
        protected String doInBackground(String... params) {
            service.getRate(params[1], params[0] ,new Callback<ConversionRate>() {

                public void failure(RetrofitError retrofitError) {
                    Log.e("Lindsay", "uh oh" + retrofitError);
                }

                public void success(ConversionRate cr, Response response) {
                    Log.e("Lindsay", "rate=" + cr.getRate());

                    updateDisplay(cr.getRate());
                }
            });
            return null;
        }
    }
}