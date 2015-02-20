package com.example.currencyconverter;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by JON-JULIUS on 2/17/2015.
 */
public class ConversionRate {

    private String To;
    private String From;
    private String Rate;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     * The To
     */
    public String getTo() {
        return To;
    }

    /**
     *
     * @param To
     * The To
     */
    public void setTo(String To) {
        this.To = To;
    }

    /**
     *
     * @return
     * The From
     */
    public String getFrom() {
        return From;
    }

    /**
     *
     * @param From
     * The From
     */
    public void setFrom(String From) {
        this.From = From;
    }

    /**
     *
     * @return
     * The Rate
     */
    public String getRate() {
        return Rate;
    }

    /**
     *
     * @param Rate
     * The Rate
     */
    public void setRate(String Rate) {
        this.Rate = Rate;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}