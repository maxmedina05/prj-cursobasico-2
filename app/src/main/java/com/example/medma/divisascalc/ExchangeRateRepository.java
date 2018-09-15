package com.example.medma.divisascalc;

import java.util.HashMap;

public class ExchangeRateRepository {

    private ExchangeRateRepository _instance = null;
    private HashMap<String, Double> exchangeRates;

    private ExchangeRateRepository() {
        if(_instance == null) {
            _instance = new ExchangeRateRepository();
            exchangeRates = new HashMap<>();
            initializeList();
        }
    }

    private void initializeList() {
        exchangeRates.put("USD-DOP", 49.82);
        exchangeRates.put("DOP-USD", 0.020);
        exchangeRates.put("EUR-DOP", 57.97);
        exchangeRates.put("DOP-EUR", 0.017);
    }

}
