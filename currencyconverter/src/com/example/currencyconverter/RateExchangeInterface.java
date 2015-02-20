package com.example.currencyconverter;
import retrofit.Callback;
import retrofit.http.Query;
import retrofit.http.GET;

/**
 * Created by JON-JULIUS on 2/17/2015.
 */
public interface RateExchangeInterface {
    @GET("/fetchRate")
    void getRate(@Query("from") String from, @Query("to") String to,
                 Callback<ConversionRate> callback);
}
