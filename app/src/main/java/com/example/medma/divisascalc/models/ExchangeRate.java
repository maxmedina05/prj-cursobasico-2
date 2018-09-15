package com.example.medma.divisascalc.models;

public class ExchangeRate {

    private String currencyFrom;
    private String currencyTo;
    private double exchangeRate;

    public ExchangeRate(String currencyFrom, String currencyTo, double exchangeRate) {
        this.currencyFrom = currencyFrom;
        this.currencyTo = currencyTo;
        this.exchangeRate = exchangeRate;
    }

    public String getCurrencyFrom() {
        return currencyFrom;
    }

    public void setCurrencyFrom(String currencyFrom) {
        this.currencyFrom = currencyFrom;
    }

    public String getCurrencyTo() {
        return currencyTo;
    }

    public void setCurrencyTo(String currencyTo) {
        this.currencyTo = currencyTo;
    }

    public double getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }
}
