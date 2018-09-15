package com.example.medma.divisascalc;

/**
 * Represents a real monetary value with it's ISO code that illustrates it.
 */
class Currency {

    private String symbol;
    private double amount;

    public Currency(String symbol, double amount) {
        this.symbol = symbol;
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}
