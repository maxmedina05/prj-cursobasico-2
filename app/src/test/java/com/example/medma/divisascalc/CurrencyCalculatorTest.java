package com.example.medma.divisascalc;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class CurrencyCalculatorTest {

    @Test
    public void shouldCalculateExchangeRate() {
        CurrencyCalculator calculator = new CurrencyCalculator();
        Currency usd = new Currency("USD", 100);
        ExchangeRate exRate = new ExchangeRate("USD", "DOP", 50);
        Currency dop = null;
        try {
            dop = calculator.computeExchange(usd, exRate);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(5000, dop.getAmount(), 0.05);
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void shouldThrowAnInvalidCurrencyException() throws InvalidCurrencyException {
        CurrencyCalculator calculator = new CurrencyCalculator();
        Currency usd = new Currency("PEN", 100);
        ExchangeRate exRate = new ExchangeRate("USD", "DOP", 50);

        thrown.expect(InvalidCurrencyException.class);
        thrown.expectMessage("Invalid Currency. The expected currency is USD");

        calculator.computeExchange(usd, exRate);
    }
}
