package com.example.medma.divisascalc.helpers;

import com.example.medma.divisascalc.InvalidCurrencyException;
import com.example.medma.divisascalc.models.Currency;
import com.example.medma.divisascalc.models.ExchangeRate;

public final class CurrencyCalculator {

    public static Currency computeExchange(Currency value, ExchangeRate exRate) throws InvalidCurrencyException {
        if(!value.getSymbol().equals(exRate.getCurrencyFrom()))
            throw new InvalidCurrencyException(new Currency(exRate.getCurrencyFrom(), 0));

        return new Currency(exRate.getCurrencyTo(), value.getAmount() * exRate.getExchangeRate());
    }
}
