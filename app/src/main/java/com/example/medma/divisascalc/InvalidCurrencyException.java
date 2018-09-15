package com.example.medma.divisascalc;

import com.example.medma.divisascalc.models.Currency;

public class InvalidCurrencyException extends Exception {

    public InvalidCurrencyException(Currency currency) {
        super(String.format("Invalid Currency. The expected currency is %s", currency.getSymbol()));
    }
}
