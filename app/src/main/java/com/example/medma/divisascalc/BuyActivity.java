package com.example.medma.divisascalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class BuyActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etCustomerInput;
    EditText etOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy);

        etCustomerInput = findViewById(R.id.et_input);
        etOutput = findViewById(R.id.et_output);
        findViewById(R.id.btn_calculate).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        double input = Double.parseDouble(etCustomerInput.getText().toString());
        try {
            computeExchangeRate(input);
        } catch (InvalidCurrencyException e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }

    private void computeExchangeRate(double value) throws InvalidCurrencyException {
        Currency usd = new Currency("USD", value);
        ExchangeRate exRate = new ExchangeRate("USD", "DOP", 50);
        Currency dop = CurrencyCalculator.computeExchange(usd, exRate);

        UpdateUI(Double.toString(dop.getAmount()));
    }

    private void UpdateUI(String output) {
        etOutput.setText(output);
    }
}
